File xmlFile = new File(path);

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setFeature(
        "http://apache.org/xml/features/nonvalidating/load-external-dtd",
        false);
DocumentBuilder builder = factory.newDocumentBuilder();

document = builder.parse(xmlFile); //or parse the String

document.getDocumentElement().normalize();