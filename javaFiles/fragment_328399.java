String expectedXML = "some xml";
 String actualXML = "some xml";

 DetailedDiff diff1 = new DetailedDiff(XMLUnit.compareXML(expectedXML, actualXML));
 diff1.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());
 System.out.println("Differences found: " + diff1.getAllDifferences().toString());