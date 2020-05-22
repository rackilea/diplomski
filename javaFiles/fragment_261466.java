if (rs.next()){ //I used `if` since we expect only one row. 
    request.setAttribute("fi", rs.getString("F"));   
    request.setAttribute("fi1", rs.getString("S"));  
    request.setAttribute("fi2", rs.getString("T"));  
    request.setAttribute("fi3", rs.getString("FO")); 
    request.setAttribute("fi4", rs.getString("FI")); 
}

request.getRequestDispatcher("result.jsp").forward(request, response);