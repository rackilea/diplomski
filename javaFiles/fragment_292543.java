package com.employee.service.impl;

    import org.junit.Before;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

    import com.domain.vo.Document;
    import com.domain.vo.Employee;
    import com.domain.objMother.EmployeeMother;
    import com.employee.service.HomeEmployeeService;
    import com.util.annotations.TransactionalDevTest;

    import static org.junit.Assert.*;

    @RunWith(SpringJUnit4ClassRunner.class)
    @TransactionalDevTest
    public class HomeEmployeeServiceImplIntegrationTest {

        @Autowired
        protected JdbcTemplate jdbcTemplate;

        @Autowired
        HomeEmployeeService homeEmployeeService;

        @Autowired
        EmployeeMother empMother;

        Employee empJohnDoe;

        @Before
        public void beforeEachTest() throws Exception {
            empJohnDoe = empMother.getEmpJohnDoe();
            empMother.insert(empJohnDoe);
        }

        /**
         * You should not be able to add a document with the same name
         * <code>uploadDocument</code> should not insert the document if it has the same name 
         */
        @Test
        public void shouldNotBeAbleToAddSameDoc(){
            Document doc = new Document();
            Long id = jdbcTemplate.queryForObject("select max(td.ID)+1 from tab_documents td", Long.class);
            doc.setId(id);
            doc.setFileName("SameOldDocument");

            homeEmployeeService.uploadDocument(empJohnDoe.getIdentity(), doc);

            id = jdbcTemplate.queryForObject("select max(td.ID)+1 from tab_documents td", Long.class);
            doc.setId(id);
            homeEmployeeService.uploadDocument(empJohnDoe.getIdentity(), doc);

            Long docNo = jdbcTemplate.queryForObject("select count(id) from tab_documents td where doc_file_name = '" + doc.getFileName() + "'", Long.class);

            if(docNo.compareTo(new Long(2)) == 0){
                assertEquals("I was able to add a document twice with the same name!", new Long(1), docNo);
            }
            else{
                assertEquals("Something went wrong when adding two documents with the same name! The document should be added once or twice, but the result is different!", new Long(1), docNo);
            }
        }
    }