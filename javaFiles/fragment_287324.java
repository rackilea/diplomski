public class Controller {

    private volatile Object obj = new Object();

    public Object get(){ return obj; }
    public void set(Object o){ obj = o; }
}