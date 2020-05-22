transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
                            "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);// creating output
                                                            // stream
            transformer.transform(source, result);