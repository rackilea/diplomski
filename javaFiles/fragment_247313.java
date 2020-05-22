private String makePretty(double number) {

  String r = mFormat.format(number);

  if (r.indexOf("k") > 0) {
    r = r.replace("k", "rb");
  } else if (r.indexOf("m") > 0) {
    r = r.replace("m", "jt");
  } else if (r.indexOf("b") > 0) {
    r = r.replace("b", "m")
  }

  return r;
}