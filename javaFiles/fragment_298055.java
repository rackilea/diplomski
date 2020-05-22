public void getConfirm(HttpServletRequest request, HttpServletResponse response) { 

Logger.getLogger(this.getClass()).warning("Inside Confirm Servlet");  
    response.setContentType("text/html"); 

    // do some works

    //EmployeeDao employeeDao=new EmployeeDao();
    employeeDao.listEmployees();         //line 55

    }