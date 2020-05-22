PDDocument doc = PDDocument.load(new URL("https://issues.apache.org/jira/secure/attachment/12977270/Report_Template_DE.pdf").openStream());
PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
PDVariableText field = (PDVariableText) acroForm.getField("search_query");
List<PDField> fields = acroForm.getFields();
PDFont font = PDType0Font.load(doc, new FileInputStream("c:/windows/fonts/arialuni.ttf"), false);

PDResources res = acroForm.getDefaultResources();
String fontName = res.add(font).getName();
String defaultAppearanceString = "/" + fontName + " 10 Tf 0 g";

field.setDefaultAppearance(defaultAppearanceString);
field.setValue("李柱");

acroForm.flatten(fields, true);
doc.save("saved.pdf");
doc.close();