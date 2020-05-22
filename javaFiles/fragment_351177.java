Test test = method.getAnnotation(Test.class);
    URL resource = ClassLoader.getSystemResource("test.json");
    InputStream stream = resource.openStream();
    String data_all = IOUtils.toString(stream, "UTF-8");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(data_all);
    JsonNode testNode = rootNode.get(test.testName());
    if (!testNode.get("Execute").asText().equals("Yes")) {
        throw new SkipException("Skipping the test as per Configuration");
    }
    if (testNode.get("Obsolete").asText().equals("Yes")) {
        throw new SkipException("Skipping the test as test is obsolete.");
    }
    userName = testNode.get("testData").get("userName").toString();
    password = testNode.get("testData").get("password").toString();