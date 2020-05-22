Namespace ns = Namespace.getNamespace("", "http://www.opengis.net/kml/2.2");
    Namespace ns2 = Namespace.getNamespace("gx", "http://www.google.com/kml/ext/2.2");

    Element kml = new Element("kml", ns);
    kml.addNamespaceDeclaration(ns2);
    Document kmlDocument = new Document(kml);

    Element folder = new Element("folder");
    Element placemark = new Element("placemark");
    folder.addContent(placemark);

    kmlDocument.getRootElement().addContent(folder);

    XMLOutputter xmlOutput = new XMLOutputter();
    xmlOutput.setFormat(Format.getPrettyFormat());
    xmlOutput.output(kmlDocument, new FileWriter("./prueba.kml"));