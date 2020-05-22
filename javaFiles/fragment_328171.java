private static File recentLog(File directory)
{
    File[] files = directory.listFiles();
    // sort
    Arrays.sort(files, new Comparator<File>()
    {
        @Override
        public int compare(File f1, File f2)
        {
            // reverse comparison, looking for the highest value of lastModified
            return -Long.compare(f1.lastModified(), f2.lastModified());
        }
    });
    // find first acceptable file
    for (File file : files)
    {
        if (accept(file))
        {
            return file;
        }
    }
    // no acceptable files found
    return null;
}