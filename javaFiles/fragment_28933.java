class Updater {
    Updater(String shouldUpdate, String reallyShouldUpdate) {...}
    boolean method1() { return shouldUpdate.equals("yes"); }
    boolean method2() { return reallyShouldUpdate.equals("yes!"); }
    boolean isUpdateNeeded() { ...}
}

class UpdaterTest {
    @Test
    void testUpdateIsNeededIfShouldUpdateAndReallyShouldUpdate() {
        String shouldUpdate = "yes";
        String reallyShouldUpdate = "yes!"
        assertTrue(new Updater(shouldUpdate, reallyShouldUpdate).isUpdateNeeded());
    }
    .... more test cases .....
}