RandomAccessFile raFile = new RandomAccessFile(f, "r");
    o = response.getOutputStream();
    // buf = new BufferedInputStream(in);
    byte[] dataBytes = new byte[DOWNLOAD_BUFFER_SIZE];
    int readed;
    raFile.seek(r.getStart());
    while ((readed = raFile.read(dataBytes)) != -1)
    {
        try
        {
            o.write(dataBytes, 0, readed);
        }
        catch (Exception e)
        {
            logger.error("-- Client Aborted Download --");
            break;
        }
    }