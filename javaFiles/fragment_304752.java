public void selectChk(String v) throws Exception {
try {
    driver.findElement(By.xpath(".//* [@id='ctl00_ctl00_MainContent_ChildContent1_frmClear_dgCashed_ctl"+v+"_chkSelect']"))
            .click();
} catch (AssertionError Ae) {
    Ae.printStackTrace();
}
}