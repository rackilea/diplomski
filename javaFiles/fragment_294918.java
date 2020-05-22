PDResources res = pageToAdd.getResources();
PDResources newres = new PDResources();

newres.setFonts(res.getFonts());
pageToAdd.setResources(newres);
outputDoc.addPage(pageToAdd);