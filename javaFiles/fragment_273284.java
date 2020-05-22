import java.io.*;

public class IsPng {

    public static void main(String ...filenames) throws Exception {
        if(filenames.length == 0) {
            System.err.println("Please supply filenames.");
            return;
        }

        for(String filename : filenames) {
            if(isPng(new File(filename))) {
                System.out.println(filename + " is a png.");
            } else {
                System.out.println(filename + " is _not_ a png.");
            }
        }
    }

    private static final int MAGIC[] = new int[] { 0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a };

    private static boolean isPng(File filename) throws Exception {
        FileInputStream ins = new FileInputStream(filename);
        try {
            for(int i = 0; i < MAGIC.length; ++i) {
                if(ins.read() != MAGIC[i]) {
                    return false;
                }
            }
            return true;
        } finally {
            ins.close();
        }
    }

}