public class MyFileFilter extends FileFiter() {

    String extension;
    String description;

    public MyFileFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
   }

    ....
}