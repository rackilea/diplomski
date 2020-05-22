//the interface
interface Runnable {
    void run()
}

//where it's specified
void execute(Runnable runnable) {
    runnable.run();
}

//specifying argument using lambda
execute(() -> /* code here */);