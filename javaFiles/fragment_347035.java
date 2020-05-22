List<Thread> threads = new ArrayList<Thread>();
for(int i = 0; i < 10; i++) {
    Thread t = new Thread(new Task(i));
    threads.add(t);       
    t.start();   
}  

for(Thread t: threads) {
    t.join();
}

// later I need more work

threads = new ArrayList<Thread>();
for(int i = 0; i < 10; i++) {
    Thread t = new Thread(new Task(i));
    threads.add(t);        
    t.start();  
}  

for(Thread t: threads) {
    t.join();
}