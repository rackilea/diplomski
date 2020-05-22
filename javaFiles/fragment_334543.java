// in the main() method of Main thread
Thread [] threads = new Thread[10];
for(int i = 0; i < 10; i++) {
    // ParserThread() is a runnable thread
    threads[i] = new Thread(new ParserThread());
    threads[i].start();
}
System.out.println("All threads have been started");
for(int i = 0; i < 10; i++) {
    threads[i].join();
}
System.out.println("All threads have been finished");