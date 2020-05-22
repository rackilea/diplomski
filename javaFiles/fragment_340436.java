public static void unzipUsing7Zip(String zipFilePath,
                                   String destinationDirectory,
                                   String password) throws IOException
{
    try (val randomAccessFile = new RandomAccessFile(zipFilePath, "r");
         val randomAccessFileInStream = new RandomAccessFileInStream(randomAccessFile);
         val inArchive = openInArchive(null, randomAccessFileInStream))
    {
        val simpleInArchive = inArchive.getSimpleInterface();
        val archiveItems = simpleInArchive.getArchiveItems();

        for (val archiveItem : archiveItems)
        {
            if (!archiveItem.isFolder())
            {
                val archiveItemPath = archiveItem.getPath();
                val targetFilePath = destinationDirectory + separator + archiveItemPath;

                try (val fileOutputStream = new FileOutputStream(targetFilePath))
                {
                    archiveItem.extractSlow(data ->
                    {
                        try
                        {
                            if (archiveItemPath.indexOf(separator) > 0)
                            {
                                // Create parent folder(s)
                                val lastSeparatorIndex = archiveItemPath.lastIndexOf(separator);
                                val path = destinationDirectory + separator + archiveItemPath.substring(0, lastSeparatorIndex);
                                createDirectories(Paths.get(path));
                            }

                            fileOutputStream.write(data);
                        } catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }

                        return data.length;
                    }, password);
                }
            }
        }
    }
}