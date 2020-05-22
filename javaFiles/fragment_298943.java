val connection = object: ServiceConnection {
    override fun onServiceConnected(className: ComponentName, service: IBinder) { 
        //Something to do
    }

    override fun onServiceDisconnected(arg0: ComponentName) {
        //Something to do
    }
}