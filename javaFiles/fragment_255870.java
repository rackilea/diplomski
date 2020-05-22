class Ideone
{
    static String mainDir = "/home/myname/somefolder";
    public static Path getToolsDirPath()
    {
        return Paths.get(mainDir, "Tools/");
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(getToolsDirPath().resolve("tool.exe"));
    }
}