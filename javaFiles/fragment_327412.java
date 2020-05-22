Pattern p = Pattern.compile("^[\\(|\\[](\\d+),(\\d+)[\\)|\\]]$");
Matcher m = p.matcher("(0,100)");

if(matcher.matches()) {
    int lowerBound = Integer.parseInt(matcher.group(1));
    int upperBound = Integer.parseInt(matcher.group(2));
    System.out.println(lowerBound + "_" + upperBound);
}