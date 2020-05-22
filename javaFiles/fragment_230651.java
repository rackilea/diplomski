response.setContentType("text/html;charset=UTF-8");
response.setStatus(200);
pw = response.getWriter();
pw.println("<html>");
pw.println("<head><script>");
pw.println("window.location.href='http://www.example.com/#"
        + request.getPathInfo() + "';");
pw.println("</script></head>");
pw.println("<body>");
pw.println(getRawPageContent(request.getPathInfo()));
pw.println("</body>");
pw.println("</html>");
pw.flush();
pw.close();
return;