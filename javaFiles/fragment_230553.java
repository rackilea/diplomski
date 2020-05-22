public class MyTestClass {
 //MUST be public
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void test() throws Exception{
   //You can create new files.
    File tmpFile = tempFolder.newFile();
    System.out.println(tmpFile.getAbsolutePath());
    System.out.println(tmpFile.exists());

    //Or new Folders
    File myFolder = tempFolder.newFolder("My_Folder");
    System.out.println(myFolder.getAbsolutePath());
    System.out.println(myFolder.exists());

    //or a combination of them.
    File newFileInMyFolder = tempFolder.newFile("My_Folder\\subfile.txt");
    System.out.println(newFileInMyFolder.getAbsolutePath());
    System.out.println(newFileInMyFolder.exists());

    // The Junit rule uses the system property 'java.io.tempdir' to create them, and it handles the cleanup outside
    // the scope of your test!
    }
}