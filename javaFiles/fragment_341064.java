private void readFile()
{
    List<String> lines = null;
    try
    {
        lines = Files.readAllLines(Paths.get("/to/my/file.txt"));
    }
    catch (IOException e)
    {
        // log exception...
    }

    for (String line : lines)
    {
        System.out.println(line);
    }
}