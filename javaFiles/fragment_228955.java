@BeforeClass
public void setUP() {   
    System.out.println("Thread = " + Thread.currentThread().getId() + " - object hash = " + this.hashCode());
    testRunner = new TestNGCucumberRunner(TestRunner.class);
    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
    extentProperties.setReportPath("output/" + this.hashCode() + "-report.html");
}