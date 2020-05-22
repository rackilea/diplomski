// actual method
public Object call() throws Exception {
    return call(); // the other call
} 

// your implementation
public String call() throws Exception {
    Thread.dumpStack();
    return "Hello "+who+" from callable";
}