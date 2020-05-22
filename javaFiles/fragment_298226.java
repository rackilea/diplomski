@Test(expected = NoResultException.class) 
void testFetchAllNoResultsReturned() throws Exception {
    List<Name> namesLocal = null;
    when(Service.fetchAllNames(id)).thenThrow(
            new NoResultException(""))
    namesLocal = (service.fetchAllNames(id)
    ....
}