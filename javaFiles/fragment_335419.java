import java.io.File;

public class StartCloneFolderOnly {

    /**
     * @param args
     */
    public static void main(String[] args) {        
        cloneFolder("C:/source",
                "C:/target");       
    }

    public static void cloneFolder(String source, String target) {
        File targetFile = new File(target);
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }
        for (File f : new File(source).listFiles()) {
        if (f.isDirectory()) {
                String append = "/" + f.getName();
                System.out.println("Creating '" + target + append + "': "
                        + new File(target + append).mkdir());
                cloneFolder(source + append, target + append);
            }
        }
    }   
}