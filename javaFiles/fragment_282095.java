// Create the Object Graph
    ObjectGraph contactInfo = JAXBHelper.getJAXBContext(jc).createObjectGraph(Customer.class);
    contactInfo.addAttributeNodes("name");
    Subgraph location = contactInfo.addSubgraph("billingAddress");
    location.addAttributeNodes("city", "province");
    Subgraph simple = contactInfo.addSubgraph("phoneNumbers");
    simple.addAttributeNodes("value");

    // Output XML - Based on Object Graph
    marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, contactInfo);
    marshaller.marshal(customer, System.out);