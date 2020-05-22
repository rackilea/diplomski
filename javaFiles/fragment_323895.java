String input = " ;1=2011-10-23T16:16:53+0530;   2=2011-10-23T16:17:53+0530;3=2011-10-23T16:18:53+0530;4=2011-10-23T16:19:53+0530;";

Pattern p = Pattern.compile("(;\\d+?)?=(.+?);");
Matcher m = p.matcher(input);

while(m.find()){
    System.out.println(m.group(2));
}