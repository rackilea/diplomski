Transformer tFormer = 
  TransformerFactory.newInstance().newTransformer();
//  Set system id
  tFormer.setOutputProperty(
  OutputKeys.DOCTYPE_SYSTEM, "systmId");

  Source source = new DOMSource(doc);
  Result result = new StreamResult(System.out);
  tFormer.transform(source, result);