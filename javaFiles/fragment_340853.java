try
    {
        p = Runtime.getRuntime().exec("something");
    }
    finally
    {
        if (p != null)
        {
            IOUtils.closeQuietly(p.getOutputStream());
            IOUtils.closeQuietly(p.getInputStream());
            IOUtils.closeQuietly(p.getErrorStream());
        }
    }