HashMap<String, Callable<String>> callables = new HashMap<String, 
Callable<String>>();
for(int i =0; i < 10; i++) {
    for(int j =0; j < 10; j++) {
        String key = Integer.toString(j);
        if(!callables.containsKey(key)) {
            callables.put(key, new Callable<String>() {
                final String mKey = key; //store the current key
                public String call() throws Exception {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Inside task");
                    callables.remove(mKey); //Remove the thread from the Map
                    return "Task Completed";
                }
            });
            try {
                callables.get(key).call();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        else
            System.out.println("Task skipped: " + j);
    }
}