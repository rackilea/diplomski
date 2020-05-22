Path p = Paths.get("/your/file"); // where you want to write
FileSystem fileSystem = FileSystems.getDefault();
Iterable<FileStore> iterable = fileSystem.getFileStores();

Iterator<FileStore> it = iterable.iterator(); // iterate the FileStore instances
while(it.hasNext()) {
    FileStore fileStore = it.next();
    long sizeAvail = fileStore.getUsableSpace(); // or maybe getUnallocatedSpace()
    if (Files.getFileStore(p).equals(fileStore) { // your Path belongs to this FileStore
        if (sizeAvail > theSizeOfBytesYouWantToWrite) {
            // do your thing
        }
    }
}