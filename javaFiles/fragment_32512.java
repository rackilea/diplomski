/**
 * gets a string from the writer
 * @throws InterruptedException 
 */
public synchronized void put(String string) throws InterruptedException {
    while(hasString == true) { //we only want to put a string into the buffer if it is empty
        wait();

    }
    this.string = string;
    hasString = true;
    notify();
}

/**
 * passes on a string to the reader
 * @throws InterruptedException 
 */
public synchronized String get() throws InterruptedException {
    while(hasString == false) { //we only want to pass on a string if the buffer is NOT empty
        wait();
    }
    hasString = false;
    notify();
    return string;
}