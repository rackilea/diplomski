DirectoryResource dr = new DirectoryResource();
StorageResource dnaStore = new StorageResource(); 
for (File f : dr.selectedFiles()) {
        FileResource fr = new FileResource(f);
        String s = fr.asString();
        dnaStore = storeAll(s); 
}