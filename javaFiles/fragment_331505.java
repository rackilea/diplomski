class MyWrapper {
    private long mPeer;

    public void createPeer() {
       mPeer = createMyNativePeer();
    }

   private native long createMyNativePeer();

   public void controlPeer(int param) {
            controlPeer(mPeer, param);
   }

   private native void controlPeer(long peer, int param);

}