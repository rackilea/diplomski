import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFileInputStream;

public class Example
{
    public static void main(String[] args)
    {
        SmbFileInputStream fis = null;
        try
        {
            fis = new SmbFileInputStream("smb://DOMAIN;USERNAME:PASSWORD@SERVER/SHARE/filename.txt");
            // handle as you would a normal input stream... this example prints the contents of the file
            int length;
            byte[] buffer = new byte[1024];
            while ((length = fis.read(buffer)) != -1)
            {
                for (int x = 0; x < length; x++)
                {
                    System.out.print((char) buffer[x]);
                }
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (SmbException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (Exception ignore)
                {
                }
            }
        }
    }
}