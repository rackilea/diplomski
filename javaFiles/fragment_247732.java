public class ListFiles 
{

    public static void main(String[] args) 
    {

        // Directory path here
        String path = "."; 

        String files="";
        double maxBytes = 0;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 

        for (int i = 0; i < listOfFiles.length; i++) 
        {

            if (listOfFiles[i].isFile() && listOfFiles[i].length()>maxBytes) 
            {
                maxBytes = listOfFiles[i].length()
                files = listOfFiles[i].getName();
            }
        }
        System.out.println(files);
    }
}