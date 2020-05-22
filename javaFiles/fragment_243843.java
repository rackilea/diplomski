String inputStr = "x 123";

Pattern pattern = Pattern.compile("x (\\d+)");
Matcher matcher = pattern.matcher(inputStr);
if(matcher.find()) {
    String num = matcher.group(1);
    System.out.println(num);            
}