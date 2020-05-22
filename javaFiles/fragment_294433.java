public class YourTest {
  @Rule
  public TemporaryFolder folder= new TemporaryFolder();

  @Test
  public void testUsingTempFolder() throws IOException {
      String filePath = folder.newFile("myfile.txt").getAbsolutePath();
      FileUtils.writeFile(filePath, "some String");
      assertTrue(new File(filePath).exists());
  }
}