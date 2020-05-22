FileInputStream in = new FileInputStream(file);
try
{
    java.nio.channels.FileLock lock = in.getChannel().lock();
    try
    {
        //write
    }
    finally
    {
        lock.release();
    }
}
finally 
{
    in.close();
}