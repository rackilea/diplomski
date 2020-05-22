@Test
public void test_something() {
   FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
   builder.setColumnSensing(true);

   FlatXmlDataSet xmlDataSet = builder.build(
            this.getClass().getResourceAsStream("/dbunit/testset.xml"));
  // ...