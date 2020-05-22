Pattern pattern = Pattern.compile("\\s+(title)='([^']+)'");
Matcher matcher = pattern.matcher(" title='111' title='222' ");

while (matcher.find()) {
    System.out.println("attribute: " + matcher.group(1) + ", value: " + matcher.group(2));
}