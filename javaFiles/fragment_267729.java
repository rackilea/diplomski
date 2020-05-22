<%          Object function_name(call the function of the callable stmt) = new Object();
        int empid = Integer.parseInt(request.getParameter("empid"));
        String empname = request.getParameter("empname");
        int supid = Integer.parseInt(request.getParameter("supid"));

        int status = function_name.method(empid, empname, supid);

        if (status > 0) {
            //out.println("Employee is created");
    %>//jsp code to display if he is te employee
<%
        session.setAttribute("session", "TRUE");
        } else {
            out.println("Creation failed");
        }
    %>