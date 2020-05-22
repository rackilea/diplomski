public class InterruptableTasks {  

    private static class InterruptableTask implements Runnable{  
        Object o = new Object();  
        private volatile boolean suspended = false;  

        public void suspend(){          
            suspended = true;  
        }  

        public void resume(){       
            suspended = false;  
            synchronized (o) {  
                o.notifyAll();  
            }  
        }  


        @Override  
        public void run() {  

            while(!Thread.currentThread().isInterrupted()){  
                if(!suspended){  
                    //Do work here      
                }
                else{  
                    //Has been suspended  
                    try {                   
                        while(suspended){  
                            synchronized(o){  
                                o.wait();  
                            }                           
                        }                       
                    }  
                    catch (InterruptedException e) {                    
                    }             
                }                           
            }  
            System.out.println("Cancelled");        
        }

    }

    /**  
     * @param args  
     * @throws InterruptedException   
     */  
    public static void main(String[] args) throws InterruptedException {  
        ExecutorService threadPool = Executors.newCachedThreadPool();  
        InterruptableTask task = new InterruptableTask();  
        Map<Integer, InterruptableTask> tasks = new HashMap<Integer, InterruptableTask>();  
        tasks.put(1, task);  
        //add the tasks and their ids

        Future<?> f = threadPool.submit(task);  
        TimeUnit.SECONDS.sleep(2);  
        InterruptableTask theTask = tasks.get(1);//get task by id
        theTask.suspend();  
        TimeUnit.SECONDS.sleep(2);  
        theTask.resume();  
        TimeUnit.SECONDS.sleep(4);                
        threadPool.shutdownNow();      
    }