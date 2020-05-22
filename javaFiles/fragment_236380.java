package FSTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class FileEx extends File
{
    public FileEx(String path)
    {
        super(path);
    }

    public FileEx(File f)
    {
        super(f.getAbsolutePath());
    }

    public String[] list()
    {
        if (this.canRead() && this.isDirectory())
            {
            /*
             * Checking the length of dir is not the most reliable way to distinguish CIFS mounts.
             * However, zero directory length generally indicates something unusual,
             * so calling ls on it wouldn't hurt. Ordinary directories don't suffer any overhead this way.
             * If this "zero-size" behavior is ever changed by CIFS but list() still won't work,
             * it will be safer to call super.list() first and call this.listUsingExec if returned array has 0 elements.
             * Though it might have serious performance implications, of course.
             */
            if (this.length() > 0)
                return super.list();
            else
                return this.listUsingExec();
           }
        else
            return null;
    }

    private String[] listUsingExec()
    {
        Process p;
        String command = "/bin/ls -1a " + this.getAbsolutePath();
        ArrayList list = new ArrayList();
        try
            {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            for (String line = reader.readLine(); line != null; line = reader.readLine())
                {
                if (!line.equalsIgnoreCase(".") && !line.equalsIgnoreCase(".."))
                    list.add(line);
               }
            String[] ret = new String[list.size()];
            list.toArray(ret);
            return ret;
           }
        catch (IOException e)
            {
            return null;
           }
    }
}