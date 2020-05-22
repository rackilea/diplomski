@Test
public void testGetCompanies() {
  /*** Arraign ***/
  CompanyService cs = new CompanyService();

  // Setup mock db
  DB mockDb = mock(DB.class);

  // Setup fake results for query
  CompanyResult<Rows<String, String>> sampleResults = ... // build sample results here

  // Have query on mock return fake results
  when(db.query(/* match arguments */)).thenReturn(sampleResults);

  // Tell your System Under Test to use the mock collaborator
  cs.setDB(mockDb);

  /*** Act ***/
  CompanyResult<Rows<String, String>> results = cs.getCompanies();

  /*** Assert ***/
  ... // Test that results and sampleResults are effectively the same
}