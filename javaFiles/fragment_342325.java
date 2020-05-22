out.println("<html>");
out.println("<head>");
...
out.println("</div>");
String academicName = null;
if (request.getMethod().equals("POST")) {
    academicName = request.getParameter("academicName").trim();
}
out.println("</body>");
out.println("</html>");