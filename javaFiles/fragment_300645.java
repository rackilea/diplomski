Enumeration headerNames = request.getHeaderNames();
while(headerNames.hasMoreElements()) {
  String headerName = (String)headerNames.nextElement();
  out.println(headerName);
  out.println(request.getHeader(headerName));
}