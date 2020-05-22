File fXmlFile = new File(xmlFilePath);
Document doc = dBuilder.parse(fXmlFile);
doc.getDocumentElement().normalize();
NodeList nList = doc.getElementsByTagName("Worksheet"); // getting the tags "Worksheet"
Node nNode = nList.item(0); // getting the first "worksheet" tag
Element eElement = (Element) nNode; //getting the content of the worksheet tag


Element secondRow = (Element)  eElement.getElementsByTagName("Row").item(1);
Element secondCell = (Element)   secondRow.getElementsByTagName("Cell").item(1);
String secondCellText = secondCell.getTextNode();