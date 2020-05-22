@Test
public void testEmptyBuild() throws Exception {
    try {
        this.rule.execute(this.helper);
    } catch (EnforcerRuleException e) {
        Assert.fail("Rule should not fail");
    }
}