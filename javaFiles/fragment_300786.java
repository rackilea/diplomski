String pattern = "MyString=(\\w*)"; // <---- HERE
Pattern patternObj = Pattern.compile(pattern);
Matcher matcher = patternObj.matcher(e1); 
if (matcher.find()) {
    System.out.println("G1: " + matcher.group(1));
    System.out.println("G2: " + matcher.group(2));
}