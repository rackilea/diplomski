import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Main {

    /**
     * WARNING : This piece of code requires that the input file terminates by a BLANK line !
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        File f = new File("D:/abc.txt");
        RandomAccessFile file;

        try {

            file = new RandomAccessFile(f, "r");
            long file_size = file.length();

            // Let's start
            long chosen_byte = (long)(Math.random() * (file_size - 1));
            long cur_byte = chosen_byte;

            // Goto starting position
            file.seek(cur_byte);

            String s_LR = "";
            char a_char;

            // Get left hand chars
            for (;;)
            {
                a_char = (char)file.readByte();
                if (cur_byte < 0 || a_char == '\n' || a_char == '\r' || a_char == -1) break;
                else 
                {
                    s_LR = a_char + s_LR;
                    --cur_byte;
                    if (cur_byte >= 0) file.seek(cur_byte);
                    else break;
                }
            }

            // Get right hand chars
            cur_byte = chosen_byte + 1;
            file.seek(cur_byte);
            for (;;)
            {
                a_char = (char)file.readByte();
                if (cur_byte >= file_size || a_char == '\n' || a_char == '\r' || a_char == -1) break;
                else 
                {
                    s_LR += a_char;
                    ++cur_byte;
                }
            }

            // Parse ID
            if (cur_byte < file_size) 
            {
                int chosen_id = Integer.parseInt(s_LR);
                System.out.println("Chosen id : " + chosen_id);
            }
            else
            {
                throw new Exception("Ran out of bounds. But this usually never happen...");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}