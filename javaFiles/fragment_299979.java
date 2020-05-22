XMLOutputFactory xof = XMLOutputFactory.newFactory();
    XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
    xsw.writeStartDocument();
    xsw.writeStartElement("servers");

    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

    ObjectGraph outputInfo = JAXBHelper.getJAXBContext(jc)
        .createObjectGraph(Server.class);
    for (String o : output) {
        outputInfo.addAttributeNodes(o);
    }

    marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, outputInfo);

    for(Object item : ls) {
        marshaller.marshal(item, xsw);
    }
    xsw.writeEndElement();
    xsw.writeEndDocument();
    xsw.close();