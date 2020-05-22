volatile AtomicInteger i = new AtomicInteger(0);

public void work(){
    i.incrementAndGet();
    //...do some other stuff
    i = new AtomicInteger(10);//because the field i is changing the field needs to be volatile 
}