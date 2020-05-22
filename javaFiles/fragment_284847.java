Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller(); 
Map properties = new HashMap<String, String>();
properties.put(javax.xml.bind.Marshaller.JAXB_ENCODING, "YOUR-ENCODING");
jaxb2Marshaller.setMarshallerProperties(properties);
jaxb2Marshaller.setPackagesToScan("your.package");

JmsTemplate jms = new JmsTemplate(connectionFactory);
jms.setMessageConverter(new MarshallingMessageConverter(jaxb2Marshaller));
...
jms.convertAndSend(yourObject);
...