abstract class DocumentBuilder {
  public abstract Document build(File file);
}

HashMap<String, Builder> builders = new HashMap<String, Builder>();
builders.put("xml", new Builder(){ 
  public build(File file) { return new XMLDocument(file); } 
});

Builder correctBuilder = builders.get("xml");
if (correctBuilder != null)
  return correctBuilder.build()