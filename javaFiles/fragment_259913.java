public void netEvent(HTMLRequest answer) {
  String html = answer.readRawSource();

  int from = 0;
  int pos;
  while ((pos = html.indexOf("/u/", from)) != -1) {
    int end = html.indexOf("\"", pos);
    System.out.println(html.substring(pos + 3, end));
    from = html.indexOf("</a>", pos + 3);
  }
}