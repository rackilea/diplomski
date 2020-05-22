XmlReader xmlReader = mock (XmlReader.class);
mock(xmlReader.readXml()).doThrow(new IllegalArgumentException());

DeviceInfoHolderPopulator deviceInfoHolderPopulator  = new DeviceInfoHolderPopulator(xmlReader); 

//call testing method
boolean returned = spyDeviceInfoHolderPopulator.populateDeviceInfoHolder();

Assign.assignFalse(returned);