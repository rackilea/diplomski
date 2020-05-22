public class MyClass{

    private AtomicBoolean flag = new AtomicBoolean(false);

    public void method(){
        if(flag.compareAndSet(false, true)) {
            //do some bulk operation, should be synchronized
        }
        //some other staff
    }
}