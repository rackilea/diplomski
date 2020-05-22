@RequestMapping(name = "/a",method = RequestMethod.POST,produces = MediaType.ALL_VALUE)
private ResponseEntity<String> getIt(@RequestBody String path) throws ParserConfigurationException, IOException, SAXException {
    Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(new InputSource(new StringReader(path)));
   if(path.contains("Request1")){
    NodeList tagName = doc.getElementsByTagName("id");
    if(tagName.getLength() > 0){
        System.out.println(tagName.item(0).getTextContent());
    }

   }
   if(path.contains("Other1")){
        NodeList tagName = doc.getElementsByTagName("fio");
        if(tagName.getLength() > 0){
            System.out.println(tagName.item(0).getTextContent());
        }
   }
    return ResponseEntity.ok("SAVED");

}