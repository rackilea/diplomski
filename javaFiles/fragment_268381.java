ExecutorService executor = Executors.newFixedThreadPool(10)
List< Future<String> > futureList = new ArrayList<Future<String>>();
     .
     .
     .
         for (MultipartFile f : file) {
                    futureList.add(executor.submit(new ProcessMutlipartFile(file ,temp,uploadService));
                }