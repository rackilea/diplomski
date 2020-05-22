import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static junit.framework.Assert.*;

public class LocatorTest extends JerseyTest {

    public static class Employee {
        public String firstName;
        public String lastName;
        public Employee(){}
        public Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public static class Company {
        public String companyId;
        public List<Employee> employees;
        public Company(){}
        public Company(String companyId, List<Employee> employees) {
            this.companyId = companyId;
            this.employees = employees;
        }
    }

    @Path("companies")
    public static class CompanyResource {

        @Context
        private ResourceContext resourceContext;

        @Path("{companyId}/employees")
        public EmployeeResource getEmployees() {
            return resourceContext.getResource(EmployeeResource.class);
        }
    }

    public static class EmployeeResource {

        @PathParam("companyId")
        public String companyId;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Company getCompanyEmployees() {
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee("pee", "skillet"));
            emps.add(new Employee("Stack", "Overflow"));
            Company co = new Company(companyId, emps);
            return co;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(CompanyResource.class);
    }

    @Test
    public void doit() {
        Response response = target("companies/1234/employees").request().get();
        assertEquals(200, response.getStatus());
        Company co = response.readEntity(Company.class);
        assertNotNull(co.companyId);
        assertEquals("1234", co.companyId);
        assertEquals(2, co.employees.size());
        response.close();
    }
}