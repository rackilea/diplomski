final ThreadLocal<DocumentBuilderFactory> documentBuilderFactor = new ThreadLocal<DocumentBuilderFactory>(){
     public DocumentBuilderFactory  initialValue(){
       return  DocumentBuilderFactory.newInstance();
     }
}

public Document doXML(InputStream s)
{
//Some processing.
  DocumentBuilderFactory factory = documentBuilderFactor.get();
  DocumentBuilder parser = factory.newDocumentBuilder();
  Document xmlDoc = parser.parse(is);
  return xmlDoc;

}