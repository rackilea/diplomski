boolean done = false;

void functionRunInThreadA() {

    synchronized( commonLock ) {

        while( !done ) commonLock.wait();
    }

    // Here it is safe to set the variable to null
}

void functionRunInThreadB() {

    // Do something...

    synchronized( commonLock ) {
        done = true;
        commonLock.notifyAll();
    }
}