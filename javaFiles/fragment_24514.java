Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

Element speechElem = doc.createElement("speech");
doc.appendChild(speechElem);

speechElem.appendChild(doc.createElement("tm"));
speechElem.appendChild(doc.createTextNode("TEXT 1"));
speechElem.appendChild(doc.createElement("tm"));
speechElem.appendChild(doc.createTextNode("TEXT 2"));
speechElem.appendChild(doc.createElement("tm"));