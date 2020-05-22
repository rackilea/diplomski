// The File (or directory) with the old name
File oldFile = new File("old.txt");

// The File (or directory) with the new name
File newFile = new File("new.txt");

// Rename file (or directory)
boolean success = oldFile.renameTo(newFile);
if (!success) {
    // File was not successfully renamed
}