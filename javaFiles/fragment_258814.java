public class ReadFile
{
    private ArrayList<String> words;
    private String fileName;
    private Scanner x;

    public ReadFile(String path) throws FileNotFoundException
    {
        fileName = path;
        words = new ArrayList<String>();
        try
        {
            x = new Scanner(new File(fileName));
        } catch (Exception e)
        {
            throw new FileNotFoundException("File Doesn't exist in the place you specified.");
        }
    }


    public void readAndSortFile()
    {
        while (x.hasNext())
            words.add(x.next());
        Collections.sort(words);

        // Now you are done reading and sorting, so close the file.
        x.close();
    }

    .
    .
    .
}