//step 1

Path p1 = ...; //path to your potentially existing file
Path p2 = ...; //path of your new file;

if (Files.isSameFile(p1, p2)) {
  try {
  delete(p1) // delete the directory where your duplicate is located

  //step 2: insert your saving logic with zip4j ( make sure you create a new           subdirectory for each file you zip
  //step 3: eat some strawberry ice-cream 

  } catch (NoSuchFileException x) {
  System.err.format("%s: no such" + " file or directory%n", path);
  } catch (DirectoryNotEmptyException x) {
  System.err.format("%s not empty%n", path);
  } catch (IOException x) {
  // File permission problems are caught here.
  System.err.println(x);
  }
}

//use this method to delete the files in the directory before deleting it.
void delete(File f) throws IOException {
  if (f.isDirectory()) {
    for (File c : f.listFiles())
      delete(c);
  }
  if (!f.delete())
  throw new FileNotFoundException("Failed to delete file: " + f);
}