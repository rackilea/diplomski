SubSubClass subSubClass = SubSubClassBuilder.neu()
        .withField2(UUID.randomUUID())
        .withField1(5)
        .withField3("3")
        .build();

SubClass subClass = SubClassBuilder.neu()
        .withField1(66)
        .withField2(UUID.randomUUID())
        .build();