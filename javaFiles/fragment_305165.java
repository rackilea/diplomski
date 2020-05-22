static void Main(string[] args)
{
    String path = FindOnPath("java.exe");
    Console.WriteLine(path);
    Console.WriteLine(GetMachineType(path));
}