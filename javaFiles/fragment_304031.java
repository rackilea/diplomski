public class TestActivity {

    ..
    private ServiceConnection sConn;
    private Messenger messenger;
    ..
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            // Service Connection to handle system callbacks
            sConn = new ServiceConnection() {

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    messenger = null;
                }

                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    // We are conntected to the service
                    messenger = new Messenger(service);

                }
            };
    ...
            // We bind to the service
            bindService(new Intent(this, ShowNotifyService.class), sConn,
                    Context.BIND_AUTO_CREATE);
    ..

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = edt.getText().toString();
                Message msg = Message.obtain(null, ShowNotifyService.SHOW_FIRST_NOTIFY);

                msg.replyTo = new Messenger(new ResponseHandler());
                // We pass the value
                Bundle b = new Bundle();
                b.putString("data", val);

                msg.setData(b);

                try {
                    messenger.send(msg);
                } catch (RemoteException e) {                    
                    e.printStackTrace();
                }

            }

        });
    }

    // This class handles the Service response
    class ResponseHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            int respCode = msg.what;

            switch (respCode) {
                case ShowNotifyService.SHOW_FIRST_NOTIFY_RESPONSE: {
                    result = msg.getData().getString("respData");
                    //then you show the result data from service here
                }
            }
        }

    }
}