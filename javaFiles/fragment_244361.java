public static boolean executeCode(int timeLimit,String fileName)
{
    String commands[]={"CMD", "/C","cd C:\\uploads && javac " + fileName};
    ProcessBuilder p=new ProcessBuilder(commands);
    p.redirectErrorStream(true);

    File output = new File("C:\\uploads\\output.txt");
    p.redirectOutput(output);

    ...

}