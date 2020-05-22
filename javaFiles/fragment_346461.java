public class ReadAutoData {
    private static int indexFrom;
    private static int indexTo;

    @DataProvider(name = "autodata")
    public static Object[][] autodata() {
        // you should probably cache this into static variable
        Object[][] arrayObject = getExcelData("C:/dev/AutoDP.xls","NON-COMBO-DP"); 

        return java.util.Arrays.copyOfRange(arrayObject, indexFrom, indexTo);
    }

    public Class<?> autoDataWithinRange(int from, int to) {
        indexFrom = from;
        indexTo   = to;

        return ReadAutoData.class;
    }
}

@Test(dataProvider="autodata", dataProviderClass = ReadAutoData.autoDataWithinRange(0, 10))
public void autoentry(String Quote, String Garage_Zip, etc...) {