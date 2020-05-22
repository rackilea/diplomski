public static int u = 0;

public void test(){
    while (u <10) {
        synchronized(threadList){
            threadList.add(u, new Thread(){     
                int i = u;

                @Override public void run(){                    
                    System.out.println("Thread at Index: " + i);                     
                } 
            });
        }
        u++;            
    }

    threadList.get(2).start();    
}