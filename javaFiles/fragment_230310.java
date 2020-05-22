@DataProvider(name = "testData")
    public static Object[][] testDataProvider() {
        return new Object[][] {
            new String[]{ "abc", "abcd" },
            new String[]{ "abc", "abcd", "123" }
        };
    }

    @Test(dataProvider = "testData")
    public void test(String... str) {
        System.out.println("The Length is" + str.length);

    }