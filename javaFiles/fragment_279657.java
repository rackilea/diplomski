ArgumentCaptor<String> propertyKeyCaptor = ArgumentCaptor.forClass(String.class);
Mockito.verify(foo, atLeast(0)).getProperty(propertyKeyCaptor.capture(), anyString());

ArgumentCaptor<String> propertyKeyCaptor2 = ArgumentCaptor.forClass(String.class);
Mockito.verify(foo, atLeast(0)).getProperty(propertyKeyCaptor2.capture());

List<String> propertyKeyValues = propertyKeyCaptor.getAllValues();
List<String> propertyKeyValues2 = propertyKeyCaptor2.getAllValues();

assertTrue(!propertyKeyValues.isEmpty() || !propertyKeyValues2.isEmpty()); //JUnit assert -- modify for whatever testing framework you're using