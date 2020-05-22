import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

protected static ArrayList<String> yourArrayList = new ArrayList<String>();
String fileName = "C:\\Users\\myComputer\\Desktop\\test_file.txt";
    try
    {
        List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        for (int i = 0; i < lines.size(); i++)
        {
            yourArrayList.add(lines.get(i).toString());
        }
    }catch(IOException io)
    {
        io.printStackTrace();
    }