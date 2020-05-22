@Override
protected final void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

   ...
   // fetch your data as list
   List<EmployeeTable> employees = getEmployee();

   //set attribute at request scope 
   request.setAttribute("employees", employees);

   // or at session scope
   request.getSession(true).setAttribute("employees", employees);

   // do redirect/forward to your jsp..
}

// probably your getEmployee() method