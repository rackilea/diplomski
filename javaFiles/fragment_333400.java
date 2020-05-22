XMLEventFactory eventFactory = XMLEventFactory.newInstance();
XMLEvent closeTagEvent = eventFactory.createEndElement("prefix", "http://namespace.com", "elementName");
//This will create a closing tag event for a previously opened <prefix:elementName xmlns:prefix="http://namespace.com">

xmlWriter.add(closeTagEvent);

xmlWriter.flush();
xmlWriter.close();