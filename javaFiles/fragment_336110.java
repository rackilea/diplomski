HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
private final StringWriter sw = new StringWriter();

@Override
public PrintWriter getWriter() throws IOException {
    return new PrintWriter(sw);
}

@Override
public String toString() {
    return sw.toString();
}
};
request.getRequestDispatcher("email.jsp").include(request,
    responseWrapper);
String result = responseWrapper.toString();