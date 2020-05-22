RetrievePublicationService retrievePublicationService = Mockito.mock(RPS.class)
String fromDate = "real from date here";
String toDate = "real to date here";
TheClassUnderTest tcut = new TheClassUnderTest(retrievePublicationService);
String substringedFromDate = "expected from date";
String substringedToDate = "expected to date";

tcut.getSearchData(fromDate, toDate);

Mockito.verify(retriebePublicationService).getSearchData(eq(substringedFromDate ), eq(substringedToDate ));