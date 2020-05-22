public void save() throws IOException
{
    boolean[] testData = new boolean[80000];
    for(int X=0;X < testData.length; X++)
    {
        testData[X] = Math.random() > 0.5;
    }
    FileOutputStream stream = new FileOutputStream(new File("test.bin"));

    for (boolean item : testData)
    {
        stream.write(item ? 1 : 0);
    }
    stream.close();
}

public boolean[] load() throws IOException
{
    long start = System.nanoTime();
    File file = new File("test.bin");
    FileInputStream inputStream = new FileInputStream(file);
    int fileLength = (int) file.length();

    byte[] data = new byte[fileLength];
    boolean[] output = new boolean[fileLength];

    inputStream.read(data);
    for (int X = 0; X < data.length; X++)
    {
        if (data[X] != 0)
        {
            output[X] = true;
            continue;
        }
        output[X] = false;
    }
    long end = System.nanoTime() - start;
    Console.log("Time: " + end);
    return output;
}