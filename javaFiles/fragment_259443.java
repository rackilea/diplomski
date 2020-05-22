public class SharedAccessThread implements Runnable {

    private String name;
    private static SharedResource resource = new SharedResource();

    public SharedAccessThread(String name) {
            this.name = name ;
    }
    @Override
    public void run() {          
        resource.access(Thread.currentThread().getName());   
    }    
}