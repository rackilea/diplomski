if (myThread != null ) {

    Thread dummy = myThread;

    myThread = null;

    dummy.interrupt();

}