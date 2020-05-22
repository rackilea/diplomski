final A a = new A();
new Thread(new Runnable(){
    public void run(){
        a.method1();
    }
}).start();
a.method1();