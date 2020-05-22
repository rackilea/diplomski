Matcher matcher = Pattern.compile("(.*)").matcher("sample");

while (matcher.find()) {
    System.out.printf("%d to %d\r\n", 
                      matcher.start(), 
                      matcher.end());
}