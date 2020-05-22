Runtime rt = Runtime.getRuntime();
Process pr = rt.exec("curl -s -S http://foo.com/testcode/Moo.cfm?PageName=" + $(Page.Name) + "&ProjectName=" + $(ProjectName));

//Java 8 version
String result = new BufferedReader(
                           new InputStreamReader(pr.getInputStream()))
                               .lines()
                               .collect(Collectors.joining("\n"));


//Older version than java 8
BufferedReader response = new BufferedReader(new InputStreamReader(pr.getInputStream()));
StringBuilder result = new StringBuilder();
String s;
while((s = response.readLine()) != null) {
    result.append(s);
}
System.out.println(result.toString());

//You then need to close the BufferedReader if not using Java 8
response.close();