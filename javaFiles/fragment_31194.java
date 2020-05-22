protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
ServletException, IOException {

resp.setContentType("application/json");
List<Employee> employees = uds.findAll();
String json = new ObjectMapper().writeValueAsString(employees);
resp.getWriter().write(json);