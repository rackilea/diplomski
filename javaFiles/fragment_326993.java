<%@ page language="java" contentType="text/xml; charset=ISO-8859-1"
                pageEncoding="ISO-8859-1"%>
        <%

        Connection connection=DBCreation.getConnection();
        Stirng query="select latitude,longitude,time from jam_info";
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        response.setContentType("text/xml");
        out.println("<markers>");
        while(rs.next()) { 

               out.println("<marker>");
               out.println("<latitude>" + rs.getXXX("latitude") + "</latitude>");
               out.println("<longitude>" + rs.getXXX("longitude") + "</longitude>");
               out.println("<time>" + rs.getXXX("time") + "</time>");
               out.println("</marker>");
           }
        out.println("</markers>");
 %>