@Override 
public void onDataChannel(final DataChannel dc) {
    Log.d(TAG, "onDataChannel");
    executor.execute(new Runnable() {
        @Override
        public void run() {
            dataChannel = dc;
            String channelName = dataChannel.label();
            dataChannel.registerObserver(new DcObserver());
        }
    });
}