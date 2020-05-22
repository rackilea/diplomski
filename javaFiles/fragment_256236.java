// A "SingleThreadExecutor" has one work thread and an unlimited queue
ExecutorService executor = Executors.newSingleThreadExecutor();

Runnable eatPizza = () -> { System.out.println("Eating a delicious pizza"); };
Runnable cleanUp = () -> { System.out.println("Cleaning up the house"); };

// we submit tasks which will be executed on the work thread
executor.execute(eatPizza);
executor.execute(cleanUp);
// we continue immediately without needing to wait for the tasks to finish