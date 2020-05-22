import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public String readFile(String filename)
{
    String content = null;
    File file = new File(filename); //for ex foo.txt
    FileReader reader = null;
    try {
        reader = new FileReader(file);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(reader !=null){reader.close();}
    }
    return content;
}