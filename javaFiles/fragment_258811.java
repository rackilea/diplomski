Change the following code in 'View.java'     if (e.getSource() == sortButton)
    {
        ReadFile r;
        try
        {
            r = new ReadFile(field.getText());
            r.readAndSortFile();

            WriteFile w = new WriteFile(field.getText());
            w.writeFile(r.getList());

        } 
        catch (FileNotFoundException e1)
        {
            field.setText(e1.getMessage());
            e1.printStackTrace();
        }       
    }
 and change 'WriteFile.java' to public class WriteFile
{
    private Formatter x;
    private String fileName;

    public WriteFile(String address) throws FileNotFoundException
    {
        fileName = address;
        try
        {
            x = new Formatter(fileName);
        } catch (Exception e)
        {
            throw new FileNotFoundException("Could not write to file.");
        }
    }

    public void writeFile(ArrayList<String> myWords)
    {
        for (int index = 0; index < myWords.size(); index++)
            x.format("%s%s", myWords.get(index), System.lineSeparator());

        // now you are done writing so close the file.

        x.close();
    }
}
 Change 'ReadFile.java' to