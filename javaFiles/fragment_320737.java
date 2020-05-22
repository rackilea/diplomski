import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;


public class Dict
{
    protected static final int BLOCK_SIZE = 128;
    protected static final int DICT_DIZE = 32;

    public static void main(String[] args)
    {
        InputStream stdinBytes = System.in;
        byte[] input = new byte[BLOCK_SIZE];
        byte[] dict = new byte[DICT_DIZE];
        int bytesRead = 0;

        try
        {
            DictGZIPOutputStream compressor = new DictGZIPOutputStream(System.out);
            bytesRead = stdinBytes.read(input, 0, BLOCK_SIZE);

            if (bytesRead >= DICT_DIZE)
            {
                System.arraycopy(input, 0, dict, 0, DICT_DIZE);
            }

            do 
            {               
                compressor.write(input, 0, bytesRead);              

                if (bytesRead == BLOCK_SIZE)
                {
                    System.arraycopy(input, BLOCK_SIZE-1, dict, 0, DICT_DIZE);
                    compressor.setDictionary(dict);
                }

                bytesRead = stdinBytes.read(input, 0, BLOCK_SIZE);
            }
            while (bytesRead > 0);
            compressor.flush();         
            compressor.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static class DictGZIPOutputStream extends GZIPOutputStream
    {

        public DictGZIPOutputStream(OutputStream out) throws IOException
        {
            super(out);
        }

        public void setDictionary(byte[] b)
        {
            def.setDictionary(b);
        }

        public void updateCRC(byte[] input)
        {
            crc.update(input);
        }                       
    }

}