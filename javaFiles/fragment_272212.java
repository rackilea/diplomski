class ProcessRunner
{
    public static void main(String [] args)
    {
        ProcessBuilder pb = new ProcessBuilder("/usr/bin/python", "/home/myuser/py_script.py");
        Process p = pb.start();
    }
}