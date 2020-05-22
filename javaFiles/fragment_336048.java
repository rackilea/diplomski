Pattern word = Pattern.compile("(\\w+)(?=(\\s\\w+))");
Matcher m = word.matcher("Please enter your name here");

while (m.find()) {
    System.out.println(m.group(1) + m.group(2));
}