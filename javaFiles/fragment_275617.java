interface Reader
{
    default int read(File file)
    {
        final byte[] data = Files.readAllbytes(file.toPath());
        return read(data);
    }

    int read(byte[] data);
}

class ReaderA
    implements Reader
{
    int read(byte[] data)
    {
        // do somethingA
    }
}

class ReaderB
    implements Reader
{
    int read(byte[] data)
    {
        // do somethingB
    }
}