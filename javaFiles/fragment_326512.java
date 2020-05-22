if(i%3!=j){
  System.out.println(Thread.currentThread().getName()+" not the one so waiting");
  lock.wait();
}
// just keeps going...
System.out.println(Thread.currentThread().getName()+" i="+i);
i++;