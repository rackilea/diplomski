@Test
public void testName() throws Exception {
    String f = ...; // path to XML

    JAXBContext context = JAXBContext.newInstance(GTSResponse.class);
    Unmarshaller unma = context.createUnmarshaller();
    // here you can pass a inputStream instead of a new File
    GTSResponse response = (GTSResponse) unma.unmarshal(new File(f));

    List<String> result = new ArrayList<String>();
    for (Record r : response.records) {
        System.out.println("Start record");
        for (Field fi : r.fields) {
            System.out.println(fi.name + ":" + fi.data + "(Primary: "
                    + fi.primaryKey + ")");
            if (fi.name.equals("deviceID") || fi.name.equals("description"))
                result.add(fi.data);
        }
    }

    // The array this print is exactly as you want
    System.out.println(Arrays.toString(result.toArray()));

}