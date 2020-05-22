public class UploadThread implements Runnable {

    private String fileLocation;

    public UploadThread(String s){
        this.fileLocation=s;
    }

    @Override
    public void run() {
       //your api call to upload file using fileLocation
    }

    @Override
    public String toString(){
        return this.command;
    }
}

public class UploadExecutor{

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        String[] fileLocations = new String[10];

        for (int i = 0; i < 10; i++) {

            Runnable worker = new UploadThread(fileLocations[i]);

            executor.execute(worker);
        }
        executor.shutdown();

        while (!executor.isTerminated()) { }

        System.out.println("Finished uploading");
    }
}