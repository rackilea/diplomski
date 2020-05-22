import java.util.LinkedList;
import java.util.Random;

interface Listener {
    public void onChange(float f);
}
class Provider {
    LinkedList<Listener> all;
    public Provider() {
        all = new LinkedList<Listener>();
    }
    public void registerChange(Listener lst) {
        all.add(lst);
    }
    public void sendMsg() {
        Random rnd = new Random();
        for(Listener l : all) {
            try {
                l.onChange(rnd.nextFloat());
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
class Inheritance implements Listener {
    static public void main(String[] args) {
        System.load(System.getProperty("user.dir") + "/libinheritance.so");
    }
    public native void onChange(float f);
}