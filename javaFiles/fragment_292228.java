Pattern p = Pattern.compile("=\\s*(\\{[^}]*\\}|.*)");
Matcher m = p.matcher(data);
while(m.find()){
    System.out.println(m.group(1));
    System.out.println("------");
}