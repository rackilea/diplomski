public class Directory extends File {

    private ArrayList<File> children;

    Directory(String name){
        super(name);
        children = new ArrayList<File>();
    }

    void addChild(File f){ children.add(f); }
}