public class FileUser {

   private void doSomethingWithTheFile() {
        FileHolder fileHolder = new FileHolder();
        fileHolder.retrieveFile();
        File file = fileHolder.getFile();
        // use the file
    }

}