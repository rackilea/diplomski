@Test(dataProvider = "students")
public void testMethod(Class<?> clazz) throws Exception {
    DistanceCalculator dc = (DistanceCalculator) clazz.newInstance();
    assertEquals(dc.computeSpeed(3, 1), (Integer) 3, 
            clazz.getSimpleName().replace("DistanceCalculator", "") + " failed");
}

@DataProvider(name = "students")
public Object[][] dataProvider() {
    return new Object[][]{
        {AssyliasDistanceCalculator.class},
        {BobDistanceCalculator.class}};
}