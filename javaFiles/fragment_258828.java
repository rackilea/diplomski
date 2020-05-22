String text1 = "something something [[abcd]] blah blah";
String text2 = "something something [[xyz|abcd]] blah blah";

Pattern pattern = Pattern.compile("\\[\\[(?:[^|]*\\|)?(.+?)\\]\\]");

System.out.println(pattern.matcher(text1).replaceAll("$1"));
System.out.println(pattern.matcher(text2).replaceAll("$1"));