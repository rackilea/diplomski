InputStream is = new FileInputStream("test.xml");
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    XMLEventReader eventReader = inputFactory.createXMLEventReader(is, "utf-8");
    Stack<StartElement> stack = new Stack<StartElement>();
    while (eventReader.hasNext()) {
        try {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                System.out.println("processing element: " + startElement.getName().getLocalPart());
                stack.push(startElement);
            }
            if(event.isEndElement()){
                stack.pop();
            }
        }catch(XMLStreamException e){

            System.out.println("error in line: " +e.getLocation().getLineNumber());
            StartElement se = stack.pop();
            System.out.println("non-closed tag:" + se.getName().getLocalPart() + " " + se.getLocation().getLineNumber());

            throw e;
        }
    }