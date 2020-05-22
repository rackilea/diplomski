String url = "http://gmail.com";
System.out.println(url);
//Escape the . to tell the parser it is the '.' char and not the regex symbol .
String[] urlsplit = url.split("\\.");
String dnsname = "Top-level " + urlsplit[urlsplit.length - 1];
System.out.println(dnsname);