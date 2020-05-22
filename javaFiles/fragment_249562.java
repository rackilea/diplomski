@DataProvider (name = "getHRServiceData")
public Object[][] getHRServiceData() {
    return new Object[][] {
            {
                   Utils.getInputDataFromExcelFileAsList("HR");
            },
    };
}