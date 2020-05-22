class WorkerOne implements IWorker {
    @Override
    public void doWork(Resource resource){
     // do some work
    }
}

public interface IWorker {
    void doWork(Resource resource);

    default void doBetterWork(){
       Resource resource = // ...
       doWork(resource)
       reource.close();
    }
}