import java.io.File;

public class FileSearcher {

    public static void main(String[] args) {

        File f = new File("C:\\test");
        FileSearcher.search(f);
    }

    public static void search(File f) {
        if(null == f) {
            return;
        }
        System.out.print("| " + f.getAbsolutePath());
        if(f.isFile()) {
            System.out.print(" (" +  f.length() + ")");
        } else if(f.isDirectory()) {
            File[] children = f.listFiles();
            if(null != children) {
                for(File c : children) {
                    search(c);
                }
            }
        }
        System.out.println("");
    }
}