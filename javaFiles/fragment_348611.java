Pattern pattern = Pattern.compile("(?<name>(?<subname>[0-9]*\\s+)+)(?<secondName>[a-z]*)"); 
Matcher m = pattern.matcher("123 456 789 abc");
while(m.find()) {
    System.out.println(m.group("name"));//prints 123 456 789

}