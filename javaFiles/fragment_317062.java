public Object[][] getTestScenarios(String dataFileName, String testCaseName) {
    JSONArray testCase = (JSONArray) getDataFile(dataFileName).get(testCaseName);
    List<JSONObject> testScenarioArray = new ArrayList<JSONObject>();

    for (int i = 0; i < testCase.size(); i++) {
         testScenarioArray.add((JSONObject) testCase.get(i));
    }

    Object[][] dataProviderArray = new Object[testScenarioArray.size()][];
    for (int scenario = 0; scenario < testScenarioArray.size(); scenario++) {
        String scenarioName = null;

        if ((String) testScenarioArray.get(scenario).get("scenario") != null) {
            scenarioName = (String) testScenarioArray.get(scenario).get("scenario");
        } else {
            scenarioName = "No scenario name specified";
        };
        dataProviderArray[scenario] = new Object[] { scenarioName, (JSONObject) testScenarioArray.get(scenario) };
    }
    return dataProviderArray;
}