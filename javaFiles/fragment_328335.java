import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
...

String[] commands = {"/usr/bin/touch", "/home/blah/test.txt"};
//this could be set to a specific directory, if desired
File dir = null;
BufferedReader is = null;
BufferedReader es = null;

try
{
    Process process;
    if (dir != null)
        process = Runtime.getRuntime().exec(commands, null, directory);
    else
        process = Runtime.getRuntime().exec(commands);
    String line;
    is = new BufferedReader(new InputStreamReader(process.getInputStream()));
    while((line = is.readLine()) != null)
        System.out.println(line);
    es = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    while((line = es.readLine()) != null)
        System.err.println(line);

    int exitCode = process.waitFor();
    if (exitCode == 0)
        System.out.println("It worked");
    else
        System.out.println("Something bad happend. Exit code: " + exitCode);
} //try
catch(Exception e)
{
    System.out.println("Something when wrong: " + e.getMessage());
    e.printStackTrace();
} //catch
finally
{
    if (is != null)
        try { is.close(); } catch (IOException e) {}
    if (os != null)
        try { es.close(); } catch (IOException e) {}
} //finally