public static Employee createEmp(String empCode, String empType, String deptName) {
    Employee emp = new Employee();
    emp .empCode= empCode;
    emp .empType= empType;
    emp .deptName= deptName;
    return emp ;
}