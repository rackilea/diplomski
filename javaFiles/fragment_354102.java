Pattern pattern = Pattern.compile("[Q|A][ ]*");

String s = "Q   How much room was there between the bike rack and the snow pile?";

Matcher match = pattern.matcher(s);

System.out.println(match.replaceFirst(""));