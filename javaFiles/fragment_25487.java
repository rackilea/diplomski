String ISBN = "ISBN: 123-456-789-112-3, ISBN: 1234567891123";

Pattern pattern = Pattern.compile("(\\d-?){13}");
Matcher matcher = pattern.matcher(ISBN);

while (matcher.find())
    System.out.println(matcher.group());