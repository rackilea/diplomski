String s = "tro[tro%tro[%trololo";
Pattern regex = Pattern.compile("^(?:(?!\\[%).)*");
 Matcher matcher = regex.matcher(s);
 while(matcher.find()){
        System.out.println(matcher.group());  // output : tro[tro%tro
}