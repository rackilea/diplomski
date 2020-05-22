<code>
private ServiceListener mA2DPProfileListener = new ServiceListener(){
//anonymous inner type. etc.
    public void onServiceConnected(int profile, BluetoothProfile proxy) {
        //cast the BluetoothProfile object to the profile you need, say 
        //BluetoothA2DP proxyA2DP = (BluetoothA2DP) proxy;
        int currentState = proxyA2DP.getConnectionState(mDevice);
        //mDevice is the BluetoothDevice object you can get from
        //BluetoothAdapter.getRemote...
    }

    public void onServiceDisconnected(int profile) {
    }
}
</code>