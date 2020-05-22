@Given("^me a hello, please. Best Regards '(.*)'.$")
    public void hello(String name, List<GherkinCondition> conditions) {
        int i = 0;
        for (GherkinCondition gherkinCondition : conditions) {
            i++;
            logger.info(String.format("  expected contition N°%d=%s", i, gherkinCondition.getExpected()));
            logger.info(String.format("  actual   contition N°%d=%s", i, gherkinCondition.getActual()));
        }
        logger.info("Hello " + name + "!");
    }

    @Given("^me a cat, please. Best Regards '(.*)'.$")
    public void hello(String name) {
        logger.info("Take my cat " + name + "!");
    }

    @Given("^me a bye, please. Best Regards '(.*)'.$")
    public void bye(String name, Map<String, String> params) {
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            i++;
            logger.info(String.format("  Key N°%d: %s   Value:%s", i, entry.getKey(), entry.getValue()));
        }
        logger.info("Bye " + name + "!");
    }