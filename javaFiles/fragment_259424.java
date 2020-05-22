try {
            File file = new File("/path/to/your/file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(YouRootClassForOrder.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setEventHandler(
                    new ValidationEventHandler() {
                        public boolean handleEvent(ValidationEvent event ) {
                            throw new RuntimeException(event.getMessage(),
                                    event.getLinkedException());
                        }
                    });
            YouRootClassForOrder pojo = (YouRootClassForOrder) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }