Pattern pattern = Pattern.compile("\\d+(?:\\.\\d+)?"); // Match int or float
String str="INR100INRINR20.500INR";
Matcher matcher = pattern.matcher(str);
if(matcher.find()){
    System.out.println(matcher.group());
}