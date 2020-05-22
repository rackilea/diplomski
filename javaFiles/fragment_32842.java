@Test
public void thatnumberOfVisitorsIncreasesWhenAVisitorIsAdmitted() {
    final Visitors visitors = new Visitors();

    Assert.assertEquals(visitors.getNumberOfVisitors(), (Integer) 0);

    visitors.AdmitNewVisitor("name", "male", 50, "British");

    Assert.assertEquals(visitors.getNumberOfVisitors(), (Integer) 1);

    visitors.AdmitNewVisitor("name2", "female", 48, "British");

    Assert.assertEquals(visitors.getNumberOfVisitors(), (Integer) 2);
}