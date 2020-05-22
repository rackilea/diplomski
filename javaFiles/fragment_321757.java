File picRoot = Services.get(StorageService.class)
            .flatMap(s -> s.getPublicStorage("Pictures"))
            .orElseThrow(() -> new RuntimeException("Folder notavailable")); 

File[] files = picRoot.listFiles();    
if (files != null) {
    for (File file : files) {
        System.out.println("File: " + file);
    }
}