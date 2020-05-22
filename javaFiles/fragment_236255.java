@DataProvider(name = "newdata")
public static Object[][] getData() {
    return new Object[][]{
            {"20"},
            {"30"}
    };
}

@Test(dataProvider = "newdata")
public void testData(Integer age) {

    System.out.println(age);

}