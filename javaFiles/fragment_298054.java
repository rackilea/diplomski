private EmployeeDao ed;
public void init(ServletConfig config) throws ServletException {
    super.init(config);
    ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
    ed = (EmployeeDao) context.getBean("employeeDao");
}