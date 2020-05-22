public class EnvironmentTest
{
    public static void main(String[] args) throws Exception
    {
        ProcessBuilder pb = new ProcessBuilder(
            "CMD.exe"
            , "/C"
            , "start \"\" cmd /c \"set e & pause\""
        );
        pb.environment().put("ENVVAR", "This is a test");
        Process p = pb.start();
    }
}