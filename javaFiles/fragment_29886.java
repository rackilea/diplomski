Pattern pattern = Pattern.compile("[a-z]\\d", Pattern.CASE_INSENSITIVE);        
Matcher matcher = pattern.matcher("used-cell-phone-albany-m3359_l12201");

while (matcher.find()) {

    int startIndex = matcher.start();
    int endIndex = matcher.end();

    String match = matcher.group();

    System.out.println(startIndex + "-" + endIndex + " = " + match);

}