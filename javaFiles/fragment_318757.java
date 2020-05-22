public Response getEmployeeDetail(@QueryParam("") EmployeeFilter filter) ;

 public class EmployeeFilter {
    public void setEmployeeId(String id) {...}
    public void setEmpProfession(String p) {...}  
 }