AtomicBoolean roundRobin = new AtomicBoolean(false);
void mainMethod(){
     Object val;
     if (roundRobin.compareAndSet(false, true)) {
         val = implMethod1();
     } else {
        val = implMethod2();
        roundRobin.set(false);
     }
}