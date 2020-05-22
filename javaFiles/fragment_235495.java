class ClassUnderTest {

    public void init() {
        throw new RuntimeException();
    }

    public void deleteX() {
        // some things
        init();
    }
}