private void modifyManifest() throws Exception {
        Document dom = Util.readXml(S.xmlMan);

        dom.getDocumentElement().getAttributes().getNamedItem("package").setNodeValue(userInput.appPackage);

        Transformer t = tf.newTransformer();
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.VERSION, "1.0");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(xmlFile)));
    }