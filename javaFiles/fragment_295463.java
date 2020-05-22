public class ExtendedHTMLDocument extends HTMLDocument
{
    public void hackWriteLock()
    {
        writeLock();
    }

    public void hackWriteUnlock()
    {
        writeUnlock();
    }
}