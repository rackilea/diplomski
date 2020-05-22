public static boolean findStringFile(String lookingForMe, String pathFile)
{

    boolean found = false;
    try{
        BufferedReader br = new BufferedReader(new FileReader(pathFile));
        try{
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.contains(lookingForMe))
                    found = true;
            }
        } finally {
            br.close();
        }
    } catch(IOException ioe)
    {
        System.out.println("Error while opening the file !");
    }
    return found;
}