@Root(name="root")
public class Example {

   @Element
   private String someProperty;

   @ElementMap(entry="keywordFrequencies", key="key", attribute=true, inline=true)
   private Map<String, Integer> keywordFrequencies;

   // getters and setters ommited
}

Serializer serializer = new Persister();
Example ex = new Example();
// set properties of ex here...
ByteArrayOutputStream baos = new ByteArrayOutputStream();
serializer.write(ex, baos); // you can put here a FileOutputStream("fileToWrite.xml") too
String content = new String(baos.getBytes(), "UTF-8");
System.out.println(content);
// and then to deserialize
Example retrievedFromXml = serializer.read(Example.class, content);