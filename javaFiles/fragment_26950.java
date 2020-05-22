doc= PDFDocumentFactory.buildPDFDocument(file, config);

doc.addField(new StringField("path", file.getPath(), Field.Store.YES));

System.out.println(doc.get("path"));
writer.addDocument(doc);