@Test
public void testInsertTimesheet() {
    Timesheet expectedToSave = new Timesheet( 1001 ,"2019-01-10", "2019-01-05", "comment section is this ", "saved", null, null);  
    int actualInsertData = timesheetRepository.insertTimesheet(expectedToSave, 100789); //In here number of effected rows is 1 so insertTimeSheet() will return 1
    Assert.assertEquals(1, actualInsertData); //expected value is 1
}