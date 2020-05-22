Enumeration<?> names = req.getHeaderNames();
while (names.hasMoreElements()) {
  String key = (String) names.nextElement();
  Enumeration<?> values = req.getHeaders(key);
  while (values.hasMoreElements()) {
    uc.addRequestProperty(key, (String) values.nextElement());
  }
}