<%
        String size = request.getParameter("size");
        if(size == null)
            out.println("<link rel='stylesheet' href='base.css'>");
        else if(size.equals("720"))
            out.println("<link rel='stylesheet' href='720.css'>");
        else if(size.equals("460"))
            out.println("<link rel='stylesheet' href='460.css'>");
        else if(size.equals("320"))
            out.println("<link rel='stylesheet' href='320.css'>");

%>