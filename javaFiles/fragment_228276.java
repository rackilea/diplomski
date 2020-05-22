import java.io.*;
import java.util.*;
class FindFile 
{
    public String findFile(String name,File file) throws IOException
    {
        File[] list = file.listFiles();
        if (list != null)
        {
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    return findFile(name,fil);
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    return fil.getCanonicalPath();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException
    {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write the file you are trying to find:" );
        String name = scan.next();
        System.out.println("Write the directory where you want to search for the file");
        String directory = scan.next();
        String foundFile = ff.findFile(name,new File(directory));
        if (foundFile != null)
        {
            System.out.println("File was found in: " + foundFile);
        }
        else
        {
            System.out.println("File was not found");
        }

    }
}