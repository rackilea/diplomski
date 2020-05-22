@SuppressWarnings("unchecked")
@Test
public void testGetEntry_success() throws Exception {
    mGetEntry.execute(1L, mCallback);
    verify(mRepository).getEntry(eq(1L));
    verify(mCallback).onResult(eq(mDataEntry));
}