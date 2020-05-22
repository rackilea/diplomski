@Test
 public void testIocForVGObserved() throws ParseException {        
     Date aDate = sdf.parse("2015-09-15");

     mockObserver.update(aDate);
     EasyMock.expectLastCall().anyTimes();
     replay(mockObserver);

     //call SUT now
     form.setSelectedDate(aDate);
}