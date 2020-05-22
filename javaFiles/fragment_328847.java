PDFont font = PDType0Font.load(doc, new File("path/Avenir-Light.ttf"), false);
PDResources res = new PDResources();
COSName fontName = res.add(font);
acroForm.setDefaultResources(res);
String da = "/" + fontName.getName() + " 12 Tf 0 g";
acroForm.setDefaultAppearance(da);