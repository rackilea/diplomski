protected String getParametersAsHtmlInput(CSRFTesterModel model, int row,
  boolean isString) {
  String s = model.getParameters(row);
  String[] parts = s.split("&");
  StringBuffer sb = new StringBuffer();
  if ((s == null) || (s.length() == 0)) {
    if (isString) {
      sb.append("'<input type=\"hidden\" name=\"name\" value=\"value\"/>' \r\n");
    } else {
      sb.append("<input type=\"hidden\" name=\"name\" value=\"value\"/> \r\n");
    }
  }
  else if (parts.length == 1) {
    String[] pair = parts[0].split("=");
    if (isString) {
      sb.append("'<input type=\"hidden\" name=\"" + pair[0] 
        + "\" value=\"" + pair[1] + "\"/>' \r\n");
    } else {
      sb.append("<input type=\"hidden\" name=\"" + pair[0] 
        + "\" value=\"" + pair[1] + "\"/> \r\n");
    }
  }
  else {
    for (int i = 0; i < parts.length; i++) {
      String name = parts[i].split("=")[0];
      String value = parts[i].split("=").length == 1 ? "" : parts[i].split("=")[1];
      if (isString) {
        sb.append("'<input type=\"hidden\" name=\"" + name 
          + "\" value=\"" + value + "\"/>'");
      } else {
        sb.append("<input type=\"hidden\" name=\"" + name 
          + "\" value=\"" + value + "\"/>");
      }
      if ((i + 1 < parts.length) && (isString)) {
        sb.append(" + \r\n");
      } else {
        sb.append("\r\n");
      }
    }
  }
  return sb.toString();
}