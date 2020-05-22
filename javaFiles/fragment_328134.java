from("INPUT_QUEUE")
    .routeId("Test")
    .multicast()
        .beanRef("logService", "save")
        .beanRef("deserialiser", "deserialise")
    .end();