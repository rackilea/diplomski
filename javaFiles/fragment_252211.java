public class FileSearcher extends Thread{
    private Object lock = new Object();
    private Path path;
    private JLabel label;
    private String extension;

    public FileSearcher(Path p, String e, JLabel l){
        path = p;
        label = l;
        extension = e;
    }       
    public void findNext(){
        synchronized(lock){
            lock.notify();
        }   
    }   
    @Override
    public void run() {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if(file.toString().toLowerCase().endsWith(extension)){
                        label.setText(file.toString());
                        synchronized(lock){
                            try {
                                lock.wait();
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}