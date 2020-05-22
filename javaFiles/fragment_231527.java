@Test
public void listAllMocks() {
    List<Object> mocks = new ArrayList<>();

    // can be replaced by a lambda if using java 8+
    Mockito.framework().addListener(new MockCreationListener() {
        @Override
        public void onMockCreated(Object mock, MockCreationSettings settings) {
            mocks.add(mock);
        }
    });

    A a = Mockito.mock(A.class);
    B b = Mockito.mock(B.class);

    // ... do something with a, b

    // verify
    assertThat(mocks.size(), is(2));
    assertThat(mocks, hasItem(a));
    assertThat(mocks, hasItem(b));
}