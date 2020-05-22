@Test
public void testMyClass(){

    MyClass objExpected = new MyClass();
    objExpected.setMyClasslId(79662);
    objExpected.setMyClassCompanyName("BMW");
    objExpected.setCountry("DE");
    objExpected.setActive(true);

    String jsonStringActual = "{\"myClassId\":79662,"
            + "\"myClasscompanyName\":\"BMW\","
            + "\"country\":\"DE\",\"isActive\":true,"
            + "\"MyClassContacts\":[]}";
    MyClass objcActual = gson.fromJson(jsonStringActual, MyClass.class);        
    System.out.println(objExpected.toString());
    System.out.println(objActual.toString());
    assertEquals(objExpected, objActual);           
}