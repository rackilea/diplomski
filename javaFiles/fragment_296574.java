import java.util.StringTokenizer;
..
String sampleStr= "Hello <br/> there <br/>";
StringTokenizer token = new StringTokenizer(sampleStr);
System.out.println(token.nextToken());//You can use .trim()
System.out.println(token.nextToken());