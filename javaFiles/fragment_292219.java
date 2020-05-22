String s = "{ ... bla ... {text} jdjdj ... { kdkdkdkd aaa { abc }";
Pattern pattern = Pattern.compile("\\{([^{}]*)}");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1).trim()); 
}