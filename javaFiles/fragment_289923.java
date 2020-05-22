enames = request.getHeaderNames();
while (enames.hasMoreElements()) {
  String name = (String) enames.nextElement();
  String value = request.getHeader(name);
  // "name" and "value" variables contain the header + its value
}