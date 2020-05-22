while(true){
  int value = jmxConf.getCount().get() + 1;
  if(value > 10){
     break;
  }
  if(mxConfg.getCount().compareAndSet(value-1, value){
     executor.submit(new thread here);
     jmxConf.getCount().decrementAndGet();
     break;
   }
}