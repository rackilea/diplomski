XMPMetadata xmp = XMPMetadata.createXMPMetadata();
DublinCoreSchema dc = xmp.createAndAddDublinCoreSchema();
dc.setDescription("descr");
XmpSerializer serializer = new XmpSerializer();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
serializer.serialize(xmp, baos, true);
PDMetadata metadata = new PDMetadata(doc);
metadata.importXMPMetadata(baos.toByteArray());
doc.getDocumentCatalog().setMetadata(metadata);