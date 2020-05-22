@After
public void tearDown() throws Exception {
    super.tearDown();
    brokerSvc.stop();
    brokerSvc = null;
}