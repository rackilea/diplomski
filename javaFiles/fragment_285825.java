// the variable holding the result of a computation
String result = null;

FutureTask<String> runnableTask = new FutureTask<String>(
        new Callable<String>() {
            public String call() throws Exception {
                // (asynchronous) computation ...
                return "42";
            }
        });

System.out.println("result=" + result); // result=null

// this will invoke call, but it will all happen in the *same thread*
runnableTask.run();

// to have a parallel thread execute in the 'background'
// you can use java.util.concurrent.Executors
// Note: an ExecutorService should be .shutdown() properly
// Executors.newSingleThreadExecutor().submit(runnableTask);

// waits for the result to be available
result = runnableTask.get();

// you can also add timeouts:
// result = runnableTask.get(100, TimeUnit.MILLISECONDS);

System.out.println("result=" + result); // result=42