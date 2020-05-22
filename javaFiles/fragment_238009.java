YourClass myInstance = new YourClass();
YourClass myInstance2= new YourClass();
Thread thread1 = new Thread(){
    @Override
    public void run(){
        myInstance.processOutbox();
    }
};
Thread thread2 = new Thread(){
    @Override
    public void run(){
        myInstance2.processOutbox();
    }
}
thread1.start();
thread2.start();