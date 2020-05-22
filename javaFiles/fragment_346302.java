int eventType = reader.nextTag();
        while (eventType == XMLStreamConstants.START_ELEMENT) {
            String localName = reader.getLocalName();
            if (localName.equals("node")) {
                Transformer t = tf.newTransformer();
                StringWriter st = new StringWriter();
                t.transform(new StAXSource(reader), new StreamResult(st));
                String xmlNode = st.toString();
                System.out.println(nodeCount + ": " + xmlNode);
                nodeCount++;
                eventType = reader.getEventType();
                if (eventType != XMLStreamConstants.START_ELEMENT && eventType != XMLStreamConstants.END_ELEMENT) {
                    eventType = reader.nextTag();
                }
            } else {
                eventType = reader.nextTag();
            }