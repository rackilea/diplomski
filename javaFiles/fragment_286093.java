PDDocument document = PDDocument.load(SOURCE_PDF);

PDField field = removeField(document, "Signature1");
Assert.assertNotNull("Field not found", field);

document.save(TARGET_PDF);        
document.close();