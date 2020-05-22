class Delegator {

    private void doPrivateStuff(int param) { ... }

    public void doStuffOnce() {
        doPrivateStuff(1);
    }

    public void doStuffIfConditionIsMet() {
        if(condition) {
            doPrivateStuff(1);
        }
    }
}