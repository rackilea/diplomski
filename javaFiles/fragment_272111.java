@Factory(dataProvider = "dp")
public FactoryDataProviderSampleTest(StrategyInterface si) {
}

@DataProvider
static public Object[][] dp() {
  return new Object[][] {
    new Object[] { new Strategy1Impl() },
    new Object[] { new Strategy2Impl() },
  };
}