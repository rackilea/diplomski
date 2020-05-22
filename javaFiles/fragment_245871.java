class OVThread extends Thread {

    int index;

    public OVThread(int index, Runnable target) {
        super(target);
        this.index = index;
    }

}