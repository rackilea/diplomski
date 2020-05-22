public class DataProviderExample {

    @Test (dataProvider = "dp")
    public void testMethod(Map<String, String> testdata) {
        System.err.println("****" + testdata);
    }

    @DataProvider (name = "dp")
    public Object[][] getData(ITestContext ctx) {
        //This line retrieves the value of <parameter name="fileName" value="/> from within the
        //<test> tag of the suite xml file.
        String fileName = ctx.getCurrentXmlTest().getParameter("fileName");
        List<Map<String, String>> maps = extractDataFrom(fileName);
        Object[][] testData = new Object[maps.size()][1];
        for (int i = 0; i < maps.size(); i++) {
            testData[i][0] = maps.get(i);
        }
        return testData;
    }

    private static List<Map<String, String>> extractDataFrom(String file) {
        List<Map<String, String>> maps = Lists.newArrayList();
        maps.add(Maps.newHashMap());
        maps.add(Maps.newHashMap());
        maps.add(Maps.newHashMap());
        return maps;
    }
}