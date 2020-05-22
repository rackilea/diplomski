Pattern p = Pattern.compile("(?<=(?:\\bPeach\\b|\\G)\\W).*?\\b((?!Apple\\b)\\w{3,})\\b");

String msg = "Peach a nice family of fruits. Apple are not.";
Matcher m = p.matcher( msg );

while (m.find()) {
    System.out.println( m.group(1) );
}