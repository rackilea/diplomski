@Test
public void test_parse() throws IOException, DixException_Exception {
    try {
    DixServicePortType argos =  new DixService().getDixServicePort();
    CsvRequestType params = new CsvRequestType();
    params.setShowHeader(true);
    params.setUsername("your_user_name");
    params.setPassword("your_password");
    params.setDisplaySensor(true);
    // params.setProgramNumber("your_program_number"); 
    params.setPlatformId("your_device_id"); 
    params.setNbDaysFromNow(2);
    StringResponseType csvres = argos.getCsv(params);
    assertNotNull(csvres);
    System.out.println(csvres.getReturn()); 

    StringResponseType xmlres = argos.getXml(params);
    assertNotNull(xmlres);
    System.out.println(xmlres.getReturn());

    } catch (SOAPFaultException e) {
        e.printStackTrace();
        fail(e.getMessage());
    }
}