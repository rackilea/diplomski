String line = "This order was placed for QT3000! OK?"; //<a> tag string
Pattern pattern = Pattern.compile("(.*?)(\\d+)(.*)"); //insert regex provided above
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    System.out.println("group 1: " + matcher.group(1)); //This will be your link
    System.out.println("group 2: " + matcher.group(2));
    System.out.println("group 3: " + matcher.group(3));
}