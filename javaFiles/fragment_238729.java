@Test(priority = 1,groups = {"smoke})
    public void verifyABTestingPageHeader() {
        if(objABTestingPage.txtHeader.getText().equals("A/B Test Control")){
            Reports.logStatus(LogStatus.PASS);
        }
        else {
            Reports.logStatus(LogStatus.FAIL);
        }
    }