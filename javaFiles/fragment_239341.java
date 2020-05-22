public boolean formRequest(
  final String type,
  final String orientation,
  final String title,
  final String width,
  final String height,
  final String xlabel,
  final String ylabel) {

  appendAttribute(HEIGHT_ATTRIBUTE_NAME, height, request);
  appendAttribute(WIDTH_ATTRIBUTE_NAME, width, request);
  appendAttribute(Y_LABEL_ATTRIBUTE_NAME, ylabel, request);
  return request.toString();
}