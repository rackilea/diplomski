// Add our macro to the document

// Get vbaProject.bin, and attach it to wordDocumentPart

java.io.InputStream is = ResourceUtils.getResource("docm/vbaProject.bin");                  
VbaProjectBinaryPart vbaProject = new VbaProjectBinaryPart();
vbaProject.setBinaryData(is);
wordDocumentPart.addTargetPart(vbaProject);

// Get /word/vbaData.xml, and attach it to vbaProject
VbaDataPart vbaData = new VbaDataPart();
java.io.InputStream is2 = ResourceUtils.getResource("docm/vbaData.xml");                    
vbaData.setDocument( is2 );

vbaProject.addTargetPart( vbaData);     

// Change the Word document's content type!
wordDocumentPart.setContentType( new ContentType(
        ContentTypes.WORDPROCESSINGML_DOCUMENT_MACROENABLED ) );
ContentTypeManager ctm = p.getContentTypeManager();
PartName partName = wordDocumentPart.getPartName();

ctm.removeContentType( partName  );
ctm.addOverrideContentType( new java.net.URI("/word/document.xml"), 
        ContentTypes.WORDPROCESSINGML_DOCUMENT_MACROENABLED);