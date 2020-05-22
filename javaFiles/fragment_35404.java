class c1 {
  @Test(groups={"c1.verifyConfig"})
  public void verifyConfig() {
    //verify some test config parameters
  }
}

class c2 {
  @Test(dependsOnGroups={"c1.verifyConfig"})
  public void dotest() {
    //Actual test
  }
}