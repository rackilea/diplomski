public static void main(String[] args) throws IOException
{
    Path testPath = Paths.get("src/testfile.txt").toAbsolutePath();
    System.out.println("path:\t" + testPath);
    try
    {
        Charset cs = Charset.defaultCharset();
        List<String> lines = Files.readAllLines(testPath, cs);

        for (String line : lines)
        {
            System.out.println(line);
        }

    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}