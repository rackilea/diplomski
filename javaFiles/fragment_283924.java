String str = "/service1/api/v1.0/foo/{fooId}/boo?parameter=value"; 

String string = str;
while(!string.startsWith("v1.0")) {
    string = string.substring(string.indexOf("/") + 1);
}

System.out.println(string.substring(string.indexOf("/") + 1, string.indexOf("?")));