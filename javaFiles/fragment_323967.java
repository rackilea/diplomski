int retry=0;
while(retry++<5) {
     if (!mBluetoothAdapter.isEnabled()) {
        mBluetoothAdapter.enable(); 
     }
     Thread.sleep(100); //again, InterruptedException handling not shown
}

if(retry==5) {
    //Ooops, still not successful. Handle situation here.
}