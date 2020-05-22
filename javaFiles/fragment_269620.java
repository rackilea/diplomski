FileInputStream in = new FileInputStream(file);
try
{
    FileLock lock = in.getChannel().tryLock();
    if (lock == null)
    {
        //file is locked, wait or do something else
    }
    else
    {
        try
        {
            //read
        }
        finally
        {
            lock.release();
        }
    }
}
finally 
{
    in.close();
}