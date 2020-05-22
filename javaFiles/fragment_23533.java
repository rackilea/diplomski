DocumentBuilderFactory dbFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.newDocument();
Element el = doc.createElement('test');
doc.appendChild(el);


String xml = "<foo bar=\"1\">Hi <baz>there</baz></foo>";
Document doc2 = builder.parse(new ByteArrayInputStream(xml.getBytes()));

Node node = doc.importNode(doc2.getDocumentElement(), true);
el.appendChild(node);