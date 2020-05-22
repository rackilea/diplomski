import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipInputStream;  
import java.util.zip.ZipOutputStream;  

class ZipTest {    
    public static void zip(String zipFileName, String inputFile)  
            throws Exception {  
        File f = new File(inputFile);  
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(  
                zipFileName));  
        zip(out, f, f.getName());  
        System.out.println("zip done");  
        out.close();  
    }  

    private static void zip(ZipOutputStream out, File f, String base)  
            throws Exception {  
        out.putNextEntry(new ZipEntry(base));  
        FileInputStream in = new FileInputStream(f);  
        int b;  
        while ((b = in.read()) != -1)  
            out.write(b);  
        in.close();  
    }  

    public static void main(String[] args) {  
        try {  
            ZipTest t = new ZipTest();  
            t.zip("c:\\test.zip", "c:\\1.txt");  
        } catch (Exception e) {  
            e.printStackTrace(System.out);  
        }  
    }  
}