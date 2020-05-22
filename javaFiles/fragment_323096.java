@Rule
public ProviderTestRule mProviderRule =
    new ProviderTestRule.Builder(MyContentProvider.class, MyContentProvider.AUTHORITY).build();

@Test
public void verifyContentProviderContractWorks() {
    ContentResolver resolver = mProviderRule.getResolver();
    // perform some database (or other) operations
    Uri uri = resolver.insert(testUrl, testContentValues);
    // perform some assertions on the resulting URI
    assertNotNull(uri);
}