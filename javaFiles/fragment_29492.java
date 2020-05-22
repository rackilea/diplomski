public static class HasTempFolder {
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFolder= folder.newFolder("subfolder");
        // Run your code here
    }
}