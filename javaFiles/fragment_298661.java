String sdCardState = Environment.getExternalStorageState(); 
if( !sdCardState.equals(Environment.MEDIA_MOUNTED ) ) {
    displayMessage("No SD Card.");
    return;
} else {
    File root = Environment.getExternalStorageDirectory();
    lookForDownloadDirectories(root);
}

// lookForDownloadDirectories() method:

public void lookForDownloadDirectories(File dir) {
    if( dir.getName().equalsIgnoreCase("download") ) {
        doSomethingWithDownloadDirectory(dir);
    }
    String[] filesAndDirectories = dir.list();
    for( String fileOrDirectory : filesAndDirectories) {
        File f = new File(dir.getAbsolutePath() + "/" + fileOrDirectory);
        if( f.isDirectory() ) {
            lookForDownloadDirectories(f);
        }
    } 
}