String input = "0:13:13 - ID:( id ) / Name:( name ) / IP ( 177.22.3.4) Memory Function Code Error ( 1 )( 267 354 24 )( 12 15 5 )";

Matcher m = Pattern.compile("([\\d\\:]+).*ID:.*\\((.+)\\).*Name:\\((.+?)\\).*?IP \\((.+?)\\)(.+)").matcher(input);
while(m.find()){
    String date = m.group(1).trim();
    String id = m.group(2).trim();
    String name = m.group(3).trim();
    String ip = m.group(4).trim();
    String desc = m.group(5).trim();

    System.out.println("Date: " + date);
    System.out.println("ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("IP: " + ip);
    System.out.println("Desc: " + desc);
}