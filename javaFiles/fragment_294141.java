public class YourClass
{
    public static void main(String args[])
       throws Exception
    {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("name_of_your_application.exe");
        int exitVal = proc.exitValue();
        System.out.println("Process exitValue: " + exitVal);
    }
}