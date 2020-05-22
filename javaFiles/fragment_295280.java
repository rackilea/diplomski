class Obj {
    private boolean killMe = false;
    void run(){
        if(someConditionHere) {
            killMe = true;
        }
    }
    public boolean isKillable() { return killMe; }
}

class A{
    Obj o;
    void main(){
        o.run();
        if(o.isKillable()) {
            o = null;
        }
    }
}