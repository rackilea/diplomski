public class BasicRuleChain implements TestRule {
  private final RuleChain delegate;
  private final DatabaseConnectionRule databaseConnectionRule
      = new DatabaseConnectionRule();

  public BasicRuleChain() {
    delegate = RuleChain.outerRule(new LogRule())
        .around(new ConfigurationRule())
        .around(databaseConnectionRule)
        .around(new ApplicationSpecificRule());
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return delegate.apply(base, description
  }

  public Connection getConnection() {
    return databaseConnectionRule.getConnection();
  }
}