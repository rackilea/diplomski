byte[] buf = new byte[1024];

    try
    {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(targetFile));

        FileInputStream in = new FileInputStream("templates/blah.xml");

        out.putNextEntry(new ZipEntry("blah.xml"));

        int len;
        while ((len = in.read(buf)) > 0)
        {
            out.write(buf, 0, len);
        }

        out.closeEntry();
        in.close();
        out.close();
    } catch (IOException e)
    {
        e.printStackTrace();
    }