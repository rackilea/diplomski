JaxbDataFormat jaxb = new JaxbDataFormat("add.your.namespace.to.the.ObjectFactory");
jaxb.setPrettyPrint(true);

from("seda:out?concurrentConsumers=20")
    .process(new process_1())
    .marshal(jaxb)
    .process(new process_2());