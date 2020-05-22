public class Foo implements Foo_interface{    
    HashSet<Object> bnc = new HashSet<Object>();
    //thread safety using monitors
    public synchronized insert(Object o) {
        bnc.add(o);
    }
    public synchronized delete(Object o) {
        bnc.remove(o);
    }
}

private class B implements Runnable{

    Foo f;

    public B(Foo f) {
        this.f = f;
        this.f.insert(this);
    }

    public void run(){
        try{
            //some code
        }catch(Exception e{
            this.f.delete(this);
        }
    }
}

private class C implements Runnable{

    Foo f;

    public C(Foo f) {
        this.f = f;
        this.f.insert(this);
    }

    public void run(){
        try{
            //some code
        }catch(Exception e{
            this.f.delete(this);
        }
    }
}