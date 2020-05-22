Pattern pattern = Pattern.compile("(.*?)/(.*?)-([^-]+)\\..*");
Matcher matcher = pattern.matcher("DATA/2019-00-01-23.x");
if(matcher.find()){
    System.out.println(matcher.group(1)); // DATA
    System.out.println(matcher.group(2)); // 2019-00-01
    System.out.println(matcher.group(3)); // 23
}