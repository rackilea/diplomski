StringWriter sr = new StringWriter();
PrintWriter w = new PrintWriter(sr);

w.print("Some stuff");
// Flush writer to ensure that it's not buffering anything
w.flush();
// clear stringwriter
sr.getBuffer().setLength(0);

w.print("New stuff");

// write to Servlet out
w.flush();
response.getWriter().print(sr.toString());