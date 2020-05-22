Matcher matcher = Pattern.compile("\\Q${ENC}\\E(.*?)\\Q{ENC}$\\E").matcher("${ENC}1{ENC}$${ENC}2{ENC}$");

if (matcher.matches()) {
    System.out.println(matcher.group(1)); // Will print "1{ENC}$${ENC}2"
}

matcher.reset();

if (matcher.find()) {
    System.out.println(matcher.group(1)); // Will print "1"
}