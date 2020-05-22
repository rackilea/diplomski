@DataProvider(name = "myDataProvider")
public Object[][] testDataProvider(ITestContext context) {
    List<String> includedGroups = Arrays.asList(context.getIncludedGroups());

    if(includedGroups.contains("myGroup")) {
        return dataA;
    }
    else if (includedGroups.contains("myOtherGroup")) {
        return dataBC;
    }

    //...
}