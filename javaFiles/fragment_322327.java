interface Dial {}

class Gadget {
    ThreadLocal<Dial> d = new ThreadLocal<>();
}

class Gizmo implements Runnable {
    Gadget g;
    Gizmo(Gadget g) {
        this.g = g;
    }
    public void run() {}
}

{
    Gadget g = new Gadget();
    new Thread(new Gizmo(g)).start();
    new Thread(new Gizmo(g)).start();
}