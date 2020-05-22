private AtomicBoolean canWrite = new AtomicBoolean(false);  
private volatile Foo foo; 
public Foo getInstance() {
   while (foo == null) {
       if(canWrite.compareAndSet(false, true)){
           foo = new Foo();
       }
   }
   return foo;
}