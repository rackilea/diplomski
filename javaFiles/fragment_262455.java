<%
        if (request.getSession().getAttribute("time") == null) {
            request.getSession().setAttribute("time", 0);
            out.print("<META HTTP-EQUIV=\"refresh\" CONTENT=\"2\">");
        } else {
            if ((Integer) request.getSession().getAttribute("time") < 3) {
                request.getSession().setAttribute("time", (Integer) request.getSession().getAttribute("time") + 1);
                out.print("<META HTTP-EQUIV=\"refresh\" CONTENT=\"2\">");
            }
        }
    %>