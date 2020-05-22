//this is where you set what you want to happen
class IncomingHandler extends Handler {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            //this switch reads the information in the message (usually just 
            //an integer) and will do something depending on which integer is sent
            case 1: do_something();
            case 2: do_something_2(); //etc.
            default:
                super.handleMessage(msg);
        }
    }
}

final Messenger myMessenger = new Messenger(new IncomingHandler());

private ServiceConnection mConnection = new ServiceConnection() {
    public void onServiceConnected(ComponentName className,
            IBinder service) {
        myService = new Messenger(service);
        myCallbackText = (TextView)findViewById(R.id.tv01); //This is a text view which will display status information as needed
        myCallbackText.setText("Attached.");

        try {
            Message msg = Message.obtain(null,
                    1);
            msg.replyTo = mMessenger; //here we send an instance of our messenger implementation as the replyTo address
            mService.send(msg);

            msg = Message.obtain(null,
                    3, this.hashCode(), 0);
            mService.send(msg); //send a message with the value "3"
        } catch (RemoteException e) {
          //nothing you can do if the server isn't active
        }

        Toast.makeText(Service_testActivity.this, R.string.remote_service_connected,
                Toast.LENGTH_SHORT).show();//confirmation that the connection happened successfully
    }

    public void onServiceDisconnected(ComponentName className) {
        // This is called when the connection with the service has been
        // unexpectedly disconnected -- that is, its process crashed.
        mService = null;
        mCallbackText = (TextView)findViewById(R.id.tv01);//same textview as before
        mCallbackText.setText("Disconnected.");

        Toast.makeText(Service_testActivity.this, R.string.remote_service_disconnected,
                Toast.LENGTH_SHORT).show();
    }
};