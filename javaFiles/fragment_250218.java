// To clarify, this String is just an example
// Use yourScannerInstance.nextLine to get the real data
String input = "[( ?Random = <http://www.semanticweb.org/vassilis/ontologies/2013/5/Test#Hello> ), "
                + "( ?Random = <http://www.semanticweb.org/vassilis/ontologies/2013/5/Test#Bye> )]";
// Pattern improved by Brian
// was: #(.+?)>
Pattern p = Pattern.compile("#([^>]+)>");
Matcher m = p.matcher(input);
// To clarify, printing the String out is just for testing purpose
// Add "m.group(1)" to a Collection<String> to use it in further code
while (m.find()) {
    System.out.println(m.group(1));
}