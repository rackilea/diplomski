public static Integer getIVarParamValue(String urlStr) {
  Pattern p = Pattern.compile("iVar=(\\d+)");
  Matcher m = p.matcher(urlStr);
  if (m.find()) {
    return Integer.parseInt(m.group(1));
  }
  return null;
}