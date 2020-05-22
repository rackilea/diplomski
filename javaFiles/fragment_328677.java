public static void foo(){ 
        Thread.currentThread();
        Map<Thread,StackTraceElement[]> allLiveThreads = Thread.getAllStackTraces(); 
        Set<Entry<Thread,StackTraceElement[]>>  entries = allLiveThreads.entrySet();

        for(Entry<Thread,StackTraceElement[]> entry : entries){

            System.out.print("Thread: '"+ entry.getKey().getName()+"'");

            if(entry.getValue().length>1) {
                String nameofMethod = entry.getValue()[1].getMethodName(); 
                System.out.println(" and method name '"+ nameofMethod+"()'");
            }
            else {
                System.out.println(" with no methods.");
            }
        }
    }