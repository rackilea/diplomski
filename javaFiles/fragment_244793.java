A a = new A();
final A b = new A();
new Thread(new Runnable(){
    public void run(){
        b.method1();
    }
}).start();
a.method1();