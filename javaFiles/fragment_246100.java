public synchronized void printMsg() throws InterruptedException {
    wait();
    System.out.print(msg + " ");        
}

public synchronized void printTime() {      
    System.out.print(count + " ");
    count++;
    if (count % N == 0){
        notifyAll();    
    }               
}