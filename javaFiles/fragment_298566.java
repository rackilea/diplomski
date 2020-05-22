System.out.println("START MONITORING  **************");


Path faxFolder = Paths.get("E:\\activiti\\monitor\\m1");
Path faxFolder2 = Paths.get("E:\\activiti\\monitor\\m2");
WatchService watchService = FileSystems.getDefault().newWatchService();
Map<WatchKey,Path> keyMap = new HashMap<>();
WatchKey watchKey1 = faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
keyMap.put(watchKey1, faxFolder);
WatchKey watchKey2 = faxFolder2.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
keyMap.put(watchKey2, faxFolder2);


while (!Thread.currentThread().isInterrupted()) {
    WatchKey watchKey = watchService.take();
    Path dir = keyMap.get(watchKey);
    for (WatchEvent<?> event : watchKey.pollEvents()) {
        WatchEvent.Kind kind = event.kind();
        if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
            Path relativePath = (Path) event.context();
            String fileName = dir.resolve(relativePath).toString();
            System.out.println(fileName);

        }
    }
}