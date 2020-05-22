public static void main(String[] args) {

  String s = "Teststring URL=\"http://www.test.ch/status\"]http://www.test.ch/status[/URL] [IMG]http://sit.corproot.net/uploads/659_untitled.png[/IMG] \n\n";

  Pattern p = Pattern.compile("(?s)^(\\w+)[^\\[]+\\[URL=\"(.*)\"\\].*");
  Matcher m = p.matcher(s);

  if (m.matches()) {
      System.out.println(String.format("%s %s \\n\\n", m.group(1), m.group(2)));
  }

}