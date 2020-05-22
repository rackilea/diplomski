while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();

                // check the element
                if (startElement.getName().getLocalPart() == ("MyTag")) {

                    // We read the attributes from this tag

                    @SuppressWarnings("unchecked")
                    Iterator<Attribute> attributes = (Iterator<Attribute>) startElement
                            .getAttributes();
                    while (attributes.hasNext()) {
                        Attribute attribute = attributes.next();
                        if (attribute.getName().toString().equals("myattribute")) {
                            System.out.println("Attribute Value: " + attribute.getValue());
                        }
                    }
                }

                if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart() == ("MyTag")) { 
                    // do Something 
                    }
                }
            } // end while