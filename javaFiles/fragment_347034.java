ExecutorService exec = Executors.newFixedThreadPool(10);

for(int i = 0; i < 10; i++) {
    exec.submit(new Task(i));
}    

// later

for(int i = 0; i < 10; i++) {
    exec.submit(new Task(i));
}    

exec.shutdown(); // etc.