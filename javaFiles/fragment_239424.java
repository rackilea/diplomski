if(Validate.userIsAdmin(employee_id, password)) { 
        RequestDispatcher rs = request.getRequestDispatcher("Options.html");
        rs.forward(request, response);
    }
 else if(Validate.userIsNotAdmin(employee_id, password))
    {
       RequestDispatcher rs = request.getRequestDispatcher("other.url");
       rs.include(request, response);
    }
 else
    {
       out.println("Employee ID or Password is incorrect. Please try again.");
       RequestDispatcher rs = request.getRequestDispatcher("index.html");
       rs.include(request, response);
    }