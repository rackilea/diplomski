protected JSONObject getDataFile(String dataFileName) {
    String dataFilePath = "src/test/resources/";
    JSONObject testObject = null; 

    try {
        FileReader reader = new FileReader(dataFilePath + dataFileName);                        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        testObject = (JSONObject) jsonObject;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return testObject;
}