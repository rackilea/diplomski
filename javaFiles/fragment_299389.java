class ConfigNameCondition extends AnyNestedCondition {

    public ConfigNameCondition() {
        super(ConfigurationPhase.PARSE_CONFIGURATION);
    }

    @ConditionalOnProperty(name = "test.configname", value = "value1")
    static class Value1Condition {

    }

    @ConditionalOnProperty(name = "test.configname", value = "value2")
    static class Value2Condition {

    }

}