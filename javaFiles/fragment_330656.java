public static String readContactsList(String nameContact) {
        boolean match = false;   
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        String contacts = "contacts.xml";

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(contacts, new FileInputStream(contacts)); 
            while (xmlr.hasNext()) { 
                switch (xmlr.getEventType()) { 
                case XMLStreamConstants.START_DOCUMENT: 
                    System.out.println("Start Read Doc " + contacts); 
                    break;

                case XMLStreamConstants.START_ELEMENT: 
                    System.out.println("Tag " + xmlr.getLocalName());    
                    for (int i = 0; i < xmlr.getAttributeCount(); i++)
                        System.out.printf(" => attribut %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
                    break;

                case XMLStreamConstants.END_ELEMENT: 
                    System.out.println("END-Tag " + xmlr.getLocalName()); 
                    break;

                case XMLStreamConstants.COMMENT:
                    System.out.println("// comment " + xmlr.getText()); 
                    break; 

                case XMLStreamConstants.CHARACTERS: 
                    if (xmlr.getText().trim().length() > 0) {
                        if (!xmlr.getText().equals(nameContact)) {
                            System.out.println("-> " + xmlr.getText());

                            if (match) {
                                return xmlr.getText();
                            }
                        }
                        else {
                            System.out.println("-> " + xmlr.getText());

                            //This is just in case the name and the code be the same
                            if (match) {
                                return xmlr.getText();
                            }

                            match = true;
                        }
                    }
                    break;
                }
                xmlr.next();
            }
        } 
        catch (Exception e) {
            System.out.println("reader initialization error");
            System.out.println(e.getMessage()); 
        }
        return contacts;
    }