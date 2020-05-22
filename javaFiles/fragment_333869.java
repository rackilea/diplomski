private Vector<Object> vector = new Vector<Object>();    

public void putValues(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
     {
     vector.add(request.getParameter("UID"));
     }