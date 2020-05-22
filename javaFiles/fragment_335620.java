import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileCompare {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File file1 = new File("c:\\test.pdf");
        File file2 = new File("c:\\test1.pdf");     
        boolean equals = FileUtils.contentEquals(file1, file2);
        System.out.println(equals);
    }

}