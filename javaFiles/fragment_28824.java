public interface IWorker {
    void doWork(Resource resource);
}

class WorkWrapper{

    private IWorker decorated;
    public WorkWrapper(IWorker decorated){
       this.decorated = decorated;
    }
    @Override
    public doWork(){
       Resource resource = // ...
       decorated.doWork(resource);
       reource.close();
    }
}

class FooWork implements IWorker {

    @Override
    public doWork(Resource resource){
          // do something...
    } 
 }