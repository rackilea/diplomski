//from the answer in the link in the question above　
  Database db = agentContext.getCurrentDatabase();
  DocumentCollection dc = db.getAllDocuments();
  Document doc = dc.getFirstDocument();
  boolean saveFlag = false;
  while (doc != null) {
    RichTextItem body = 
    (RichTextItem)doc.getFirstItem("Body");
    System.out.println(doc.getItemValueString("Subject"));
    Vector v = body.getEmbeddedObjects();
    Enumeration e = embeddedObjs.elements();
    while(e.hasMoreElements()){
        EmbeddedObject eo = (EmbeddedObject)e.nextElement();
        if(eo.getType() == EmbeddedObject.EMBED_ATTACHMENT){

    //this next line gives Apache-POI access to the InputStream

                        InputStream is = eo.getInputStream();
            POIFSFileSystem POIfs = 
                              HWPFDocument.verifyAndBuildPOIFS(is);
            POIOLE2TextExtractor extractor = 
                              ExtractorFactory.createExtractor(POIfs);
            System.out.println("extracted text: " + extractor.getText());
                        is.close();  //closing InputStream 
                     }
                     eo.recycle();  //recycling EmbeddedObject

   //thanks to rhsatrhs for the close() and recycle() tip!