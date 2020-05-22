import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RecDir {
    public static void main(String[] args) {
        listFilesAndFilesSubDirectories("c:\\");
    }
    public static void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        if(fList!=null)
            for (File file : fList){
                if (file.isFile()){
                    System.out.print(file.getAbsolutePath());
                    MessageDigest md5=null;
                    try{md5=MessageDigest.getInstance("MD5");}catch(NoSuchAlgorithmException nsae){};
                    try(DigestInputStream dis=new DigestInputStream(new BufferedInputStream(new FileInputStream(file)), md5)){
                        while(dis.read()>=0);
                        System.out.print(" - MD5: ");
                        for(Byte b: md5.digest())
                            System.out.printf("%02x",b);
                        System.out.println();
                    }catch(IOException ioe){
                        System.out.println(" - Error: "+ioe);
                    }
                } else if (file.isDirectory()){
                    listFilesAndFilesSubDirectories(file.getAbsolutePath());
                }
            }
    }
}