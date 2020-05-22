String line = "Radius of Circle is 7 cm";
Pattern pattern = Pattern.compile("(\\d+) cm");
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    System.out.println("Value: " + matcher.group(1));
}