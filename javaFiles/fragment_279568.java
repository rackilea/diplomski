String xml = "<fragments><fragment><data>This is pure text.</data></fragment></fragments>";
    XMLEventReader xer = inputFactory.createXMLEventReader(new StringReader(xml));
    if (xer.peek().isStartDocument())
    {
        xer.nextEvent();
    }
    eventWriter.add(xer);