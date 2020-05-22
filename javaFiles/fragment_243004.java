public enum FileBufferedProcessorService implements FileProcessorService {

    SINGLETON;
    private BufferedWriter fileWriter;

    FileBufferedProcessorService(){  
       createFile();
   }
     ....

    public synchronized void writeToFile(...) {}
    public synchronized void closeFile(...) {}
}