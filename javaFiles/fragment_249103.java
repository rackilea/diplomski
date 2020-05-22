public static Observable<DownloadedFiles> downloadFiles() {        
        return getRestService().getObjectList()
        .flatMap(Observable::from)
        .flatMap(objectLimited -> getRestService().getObject(objectLimited.getPath()))
        .doOnNext(objectFull -> {
            try {
                File file = new File();
                // Extract data from objectFull and write new file to disk
                // ...
            } catch (IOException e) {
                new IOException(e);
            }})
      .collect(() -> new DownloadFiles<>(), (files, object) -> {  files.add(object});