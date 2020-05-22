import java.io.*;

public class Temp
{

    public static void main(String[] args) throws IOException
    {
        String fileName = "RandomFileThatDoesntExist";
        File file = new File(fileName);

        if(file.exists())
        {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        else
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Enter file Name:");
            String line;
            while(true)
            {
                line = br.readLine();
                File myFile = new File(line);
                if(myFile.exists())
                    break;
                else
                    System.out.println("Error, file doesn't exist!");
            }
            FileReader fr = new FileReader(line);
            BufferedReader br2 = new BufferedReader(fr);
            System.out.println("File contents:");
            while((line = br2.readLine()) != null)
            {
                System.out.println(line);
            }
        }
    }
}