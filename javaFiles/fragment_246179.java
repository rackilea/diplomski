try {
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            String Query = "select date, intime, outtime, eid  from fulltime where eid='" + eid + "'";
            ArrayList row = new ArrayList();
            ResultSet rs = st.executeQuery(Query);


     while (rs.next()) { 
                     row.add(rs.getString("date"));
                     row.add(rs.getString("intime"));
                     row.add(rs.getString("outtime"));
                     row.add(rs.getString("eid"));
    }
}
request.getSession().setAttribute("results", row);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeDetail.jsp");
            rd.forward(request, response);