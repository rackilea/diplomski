public static Collection<byte[]> sameHashes(Collection<byte[]> hashes) {
    class CollectionOfHashesMatcher extends ArgumentMatcher<Collection<byte[]>> {
        public boolean matches(Collection<byte[] actualListOfHashes) { /* ... */ }        
        public void describeTo(Description description) { /* ... */ }        
    };
    return argThat(new CollectionOfHashesMatcher(hashes));
}