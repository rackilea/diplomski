public class FileSystemListener implements FileSystemJournalListener, Runnable {
       /** The last USN to have to search until, when looking for new files added to the file system */
       private long _lastUSN;
       /** The filename of the new image */
       private String _imageFilename;

       public void run() {
          // TODO: do something with the new image
       }

       public FileSystemListener() {
          // we record the next system USN before the Camera app has a chance to add a new file
          _lastUSN = FileSystemJournal.getNextUSN();
       }

       public void fileJournalChanged() {
          long nextUSN = FileSystemJournal.getNextUSN();
          boolean imgFound = false;
          // we have to search for the file system event that is the new image
          for (long lookUSN = nextUSN - 1; (lookUSN >= _lastUSN) && !imgFound; --lookUSN) {
             FileSystemJournalEntry entry = FileSystemJournal.getEntry(lookUSN);
             if (entry == null) {
                break;
             } else {
                String path = entry.getPath();
                if (path != null) {
                   if (path.endsWith("png") || path.endsWith("jpg") || path.endsWith("bmp") || path.endsWith("gif")) {
                      switch (entry.getEvent()) {
                         case FileSystemJournalEntry.FILE_ADDED:
                            // either a picture was taken or a picture was added to the BlackBerry device
                            _lastUSN = lookUSN;
                            _imageFilename = path;
                            imgFound = true;

                            // unregister for file system events?
                            UiApplication.getUiApplication().removeFileSystemJournalListener(this);

                            // let this callback complete before responding to the new image event
                            UiApplication.getUiApplication().invokeLater(this);
                            break;
                         case FileSystemJournalEntry.FILE_DELETED:
                            // a picture was removed from the BlackBerry device;
                            break;
                      }
                   }
                }
             }
          }
       }
    }