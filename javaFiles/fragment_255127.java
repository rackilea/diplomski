boolean isFileUnlocked = false;
try {
    org.apache.commons.io.FileUtils.touch(yourFile);
    isFileUnlocked = true;
} catch (IOException e) {
    isFileUnlocked = false;
}

if(isFileUnlocked){
    // Do stuff you need to do with a file that is NOT locked.
} else {
    // Do stuff you need to do with a file that IS locked
}