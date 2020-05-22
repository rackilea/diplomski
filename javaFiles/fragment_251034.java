PDDocument doc = PDDocument.load(new File("82667884384374 (1).pdf"));
PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
PDTextField field = (PDTextField) acroForm.getField("q2_quotationPrepared");
COSName helvName = acroForm.getDefaultResources().add(PDType1Font.HELVETICA); // use different font if you want. Do not subset!
field.setDefaultAppearance("/" + helvName.getName() + " 10 Tf 0 g"); // modifies your existing DA string
field.setValue("TextEntry");        
doc.save(new File("82667884384374 (1)-new.pdf"));
doc.close();