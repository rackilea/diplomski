public void test() {
    ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
        ex.scheduleAtFixedRate(new Runnable(){
    @Override
    public void run() {
        scanDirectory(new File("."));
    }}, 1, 1, TimeUnit.SECONDS);
}

private void scanDirectory(File directory) {
    Set<File> before = new HashSet<File>();
    Set<File> after = new HashSet<File>();
    addFiles(directory, after);

   for (File f :after) {
      if (!before.contains(f)) {
         System.out.format("new file added %s", f);     
      }
   }
   for (File f :before) {
        if (!after.contains(f)) {
            System.out.format("file removed %s", f);    
        }
    }

    before.clear();
    before.addAll(after);
}

private void addFiles(File file, Collection<File> allFiles) {
    File[] files = file.listFiles();
    if (files != null) {
        for (File f : files) {
            allFiles.add(f);
            addFiles(f, allFiles);
        }
    }
}