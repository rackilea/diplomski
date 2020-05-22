ArgumentCaptor<Properties> propertiesCaptor =
    ArgumentCaptor.forClass(Properties.class);

PowerMockito.verifyStatic(SomeStaticClass.class);
SomeStaticClass.methodBeingStubbed(propertiesCaptor.capture());

Properties passedInValue = propertiesCaptor.getValue();