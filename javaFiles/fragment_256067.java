String regex = "%%(.*?)%%";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {                                                
    System.out.println(matcher.group(1));
    //                               ^------note to get the group one
}