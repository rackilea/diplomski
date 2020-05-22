FileChannel ch = null;
    try {
        ch = new FileInputStream("foo.txt").getChannel();
        // process
        ch.close();
    } catch (Exception e) {
        // error handling
    } finally {
        IOUtils.closeQuietly(ch);
    }