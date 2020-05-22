@MockClass(realClass = System.class)
public static class MockedSystem {

    @Mock
    public long currentTimeMillis() {

        // Now is always 11/11/2011
        Date fake = new Date(111,10,11);
        return fake.getTime();
    }
}