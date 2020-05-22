public String LoadFromFile(String Filename)
{
    // YOUR CODE HERE
    try
    {
        File inFile = new File(Filename);
        Scanner inText = new Scanner(inFile);
        inText.useDelimiter("[\\s,\r\n]+");
        int tempW = inText.nextInt();
        int tempH = inText.nextInt();

        SetSize(tempW, tempH);

        for (int i = 0; i < tempW; i++)
        {
            for (int j = 0; j < tempH; j++)
            {
                if (inText.hasNextInt())
                {
                    int temp = inText.nextInt();
                    Map[i][j] = temp;
                }
            }
        }

        inText.close();
        return "";
    }
    catch (Exception e)
    {
        String dir = " (No such file or directory)";
        return Filename + dir;
    }
}