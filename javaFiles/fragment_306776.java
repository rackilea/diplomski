private class DcObserver implements DataChannel.Observer {

    @Override 
    public void onMessage(final DataChannel.Buffer buffer) {

        ByteBuffer data = buffer.data; 
        byte[] bytes = new byte[data.remaining()];
        data.get(bytes);
        final String command = new String(bytes);

        executor.execute(new Runnable() {
            public void run() {
                events.onReceivedData(command);
            }
        });

    }

    @Override
    public void onStateChange() {
        Log.d(TAG, "DataChannel: onStateChange: " + dataChannel.state());
    }
}