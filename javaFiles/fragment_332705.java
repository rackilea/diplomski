String regex = "^([^()]*)\\(([^()]*)\\)(.*)$";
String s = "flow gavage(ZAB_B2_COCUM) BS";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(s);
if (matcher.matches()){
    System.out.println(matcher.group(1).trim()); 
    System.out.println(matcher.group(2).trim()); 
    System.out.println(matcher.group(3).trim()); 
}