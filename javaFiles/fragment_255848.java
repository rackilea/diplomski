public byte[] readBinaryFile(File f) throws IOException
{       
    byte[] contents = new byte[(int)f.length()];
    BufferedInputStream bis = null;
    try
    {
        bis = new BufferedInputStream(new FileInputStream(f));
        DataInputStream dis = new DataInputStream(bis);
        dis.readFully(contents);
    }
    finally
    {
        if(bis != null)
        {
            bis.close();
        }
    }           
    return contents;            
}

public void writeBinaryFile(byte[] contents, File f) throws IOException
{
    BufferedOutputStream bos = null;
    try
    {
        bos = new BufferedOutputStream(new FileOutputStream(f));
        bos.write(contents);
    }
    finally
    {
        if(bos != null)
        {
            bos.close();
        }
    }           
}