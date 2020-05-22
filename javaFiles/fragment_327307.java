public class Moveall {
public static void main(String[] args) throws IOException {
    File destinationDir = new File("/home/hadoop/Documents/movedfiles/");
    File directory = new File("/home/hadoop/Desktop/");
    File[] subfiles = directory.listFiles();
    for(File f:subfiles){
    FileUtils.moveFile(f,new File(destinationDir.getPath()+"/"+System.currentTimeMillis()+f.getName()));
    System.out.println("moved succesfully....");

    }
}