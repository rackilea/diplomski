public static void main(String[] args) throws Exception {
    HashMap<String, String> results = new HashMap<String, String>(); // Your map        
    TransformerFactory tFactory = TransformerFactory.newInstance();
    tFactory.setAttribute("http://saxon.sf.net/feature/outputURIResolver", new HashMapSaverOutputUriResolver(results)); // Set OutputURIResolver
    Transformer transformer = tFactory.newTransformer(new StreamSource(new File("xsl.xsl")));
    transformer.transform(new StreamSource(new File("schema.xsd")), new StreamResult(System.out));
    // Once the transformation has finished the Map is filled
}