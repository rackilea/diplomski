File[] listFiles=dir.listFiles();
ExecutorService tpe = Executors.newFixedThreadPool(10);
for(File file:listFiles){
    Runnable r = new Runnable() {
        @Override
        public void run() {
            String filename = file.getName();
            System.out.println(filename+":"+file.lastModified());
            if(file.lastModified() < purgeTime){
                if(!file.delete()){
                    System.out.println("can't delete file: "+filename);
                }else{
                    System.out.println("deleted: "+filename);
                }
            }                   
        }
    };
    tpe.submit(r);
}
tpe.shutdown();