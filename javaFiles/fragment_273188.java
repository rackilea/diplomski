FileOutputStream fos=null;
    InputStream is = null;
    try
    {

        is = this.getClass().getResourceAsStream("path to your exe inside the jar");
        fos = new FileOutputStream("destination path on host file system");
        byte[] buffer = new byte[1024];
        int read;
        while ((read = is.read(buffer)) > -1)
            fos.write(buffer, 0, read);

    }
    finally
    {

        if (is != null)
            is.close();
        if (fos != null)
            fos.close();
    }