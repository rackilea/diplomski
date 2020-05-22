WatchService watchService = null;
String folderString = "Your path here";

do
{
    Thread.sleep(1000);
    File dir = new File(folderString);

    if (!dir.exists())
        continue;

    watchService = FileSystems.getDefault().newWatchService();

    Path folder = Paths.get(folderString);

    folder.register(watchService,
        StandardWatchEventKinds.ENTRY_CREATE,
        StandardWatchEventKinds.ENTRY_DELETE,
        StandardWatchEventKinds.ENTRY_MODIFY);

    boolean watchStillOperational = false;

    do
    {
        WatchKey watchKey = watchService.take();

        for (WatchEvent<?> event : watchKey.pollEvents())
        {
            .....
        }

        // The following line indicates if the watch no longer works
        // If the folder was deleted this will return false.
        watchStillOperational = watchKey.reset();

    } while (watchStillOperational)

} while(true)