import java.util.concurrent.*;
import java.util.*;

public class CallBackDemo{
    public CallBackDemo(){
        System.out.println("creating service");
        ExecutorService service = Executors.newFixedThreadPool(10);

        try{
            for ( int i=0; i<10; i++){
                Callback callback = new Callback(i+1);
                MyCallable myCallable = new MyCallable((long)i+1,callback);
                Future<Long> future = service.submit(myCallable);
                //System.out.println("future status:"+future.get()+":"+future.isDone());
            }
        }catch(Exception err){
            err.printStackTrace();
        }
        service.shutdown();
    }
    public static void main(String args[]){
        CallBackDemo demo = new CallBackDemo();
    }
}
class MyCallable implements Callable<Long>{
    Long id = 0L;
    Callback callback;
    public MyCallable(Long val,Callback obj){
        this.id = val;
        this.callback = obj;
    }
    public Long call(){
        //Add your business logic
        System.out.println("Callable:"+id+":"+Thread.currentThread().getName());
        callback.callbackMethod();
        return id;
    }
}
class Callback {
    private int i;
    public Callback(int i){
        this.i = i;
    }
    public void callbackMethod(){
        System.out.println("Call back:"+i);
        // Add your business logic
    }
}