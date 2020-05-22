public enum TestFeatures implements Feature {
  @Label("Test togglz")
  TEST_TOGGLZ;
  public boolean isActive() {
    return FeatureContext.getFeatureManager().isActive(this);
  }
}