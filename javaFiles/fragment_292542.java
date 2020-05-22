package com.domain.objMother;

    import org.apache.commons.logging.Log;
    import org.apache.commons.logging.LogFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.JdbcTemplate;

    import com.domain.vo.Company;
    import com.domain.vo.Contact;
    import com.domain.vo.Employee;
    import com.domain.vo.Identification;
    import com.domain.vo.Role;
    import com.util.annotations.ObjectMother;

    @ObjectMother
    public class EmployeeMother {
        private final Log log = LogFactory.getLog(getClass());

        @Autowired
        protected JdbcTemplate jdbcTemplate;

        private Employee empJohnDoe;

        /**
         * 
         * @return returns an admin user with username djohn
         */
        public Employee getEmpJohnDoe() {
            empJohnDoe = new Employee();
            empJohnDoe.setUserName("djohn");

            Role role = new Role();
            //as only the id of the role is not nullable I set it as 1 = admin
            role.setId(new Long(1));
            empJohnDoe.setRole(role);
            empJohnDoe.setCompany(new Company());

            Identification identity = new Identification();
            identity.setFirstName("John");
            identity.setLastName("Doe");
            identity.setContact(new Contact());
            empJohnDoe.setIdentity(identity);

            return empJohnDoe;
        }

        public void setEmpJohnDoe(Employee empJohnDoe) {
            this.empJohnDoe = empJohnDoe;
        }

        /**
         * Important! this insert does not cover some details of the Employee:
         * It inserts null in the following columns:
         * pswd,
         * image,
         * cnt_id, - should be a list of associated contacts
         * salt,
         * is_active,
         * default_work_hours
         * The insert in TAB_IDENTIFICATIONS triggers TRIG_IDNT that inserts stuff in an audit table
         * For it to work we need to register a logged user
         * That's why we call PAC_SECURITY.PRO_SETCTX('emp_user_name','adminUserName'); (i used an admin)
         * I preferred doing this rather than inserting djohn in TAB_EMPLOYEES, 
         * registering djohn as logged then inserting an identity in TAB_IDENTIFICATIONS
         * and then updating djohn with the new identity
         * @param emp - Employee to be inserted
         */
        public void insert(Employee emp){
            jdbcTemplate.update("call PAC_SECURITY.PRO_SETCTX('emp_user_name','adminUserName')");

            Long identityId = jdbcTemplate.queryForObject("select max(ti.ID)+1 from tab_identifications ti", Long.class);
            emp.getIdentity().setId(identityId);

            jdbcTemplate.update(""+
                "   insert into tab_identifications ("+
                "       id, first_name, middle_name, last_name, cnp, ci_char, ci_number, birth_date, invalidity,"+
                "       cas_name, ci_issue_date, ci_issuer, cnt_id"+
                "   )" +
                "   values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{emp.getIdentity().getId(), emp.getIdentity().getFirstName(), emp.getIdentity().getMiddleName(),
                             emp.getIdentity().getLastName(), emp.getIdentity().getCnp(), emp.getIdentity().getIdCardSerial(),
                             emp.getIdentity().getIdCardNumber(), emp.getIdentity().getBirthDate(), 
                             emp.getIdentity().getInvalidity(), emp.getIdentity().getCAS(), emp.getIdentity().getCiIssueDate(),
                             emp.getIdentity().getCiIssuer(), emp.getIdentity().getContact().getId()}
            );      

            Long id = jdbcTemplate.queryForObject("select max(te.ID)+1 from tab_employees te", Long.class);
            emp.setId(id);
            jdbcTemplate.update(""+
                "   insert into tab_employees (id, user_name, code, pswd, idnt_id, role_id, comp_id, image, "+
                "       hire_date, cnt_id, salt, is_expired, is_active, default_work_hours "+
                "   )" +
                "   values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{emp.getId(), emp.getUserName(), emp.getCode(), null, emp.getIdentity().getId(),
                             emp.getRole().getId(), emp.getCompany().getId(), null, emp.getHireDate(),
                             null, null, emp.getIsExpired(), null, null
                }
            );
        }
    }