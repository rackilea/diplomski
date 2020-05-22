String input = "'John\\'s bike', 'Mary\\'s hat', 'my shoes'";
Pattern p = Pattern.compile("'(\\\\.|[^'])*'");
Matcher m = p.matcher(input);
while(m.find()){
    System.out.println(m.group());
}