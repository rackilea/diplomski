public class ShowNotifyService extends Service {

    private Messenger msg = new Messenger(new ShowNotifyHanlder());

    @Override
    public IBinder onBind(Intent arg0) {                
        return msg.getBinder();
    }

    class ShowNotifyHanlder extends Handler {

        @Override
        public void handleMessage(Message msg) {
            // This is the action 
            int msgType = msg.what;

            switch(msgType) {
            case SHOW_FIRST_NOTIFY: {
                try {
                    // Incoming data
                    String data = msg.getData().getString("data");
                    Message resp = Message.obtain(null, SHOW_FIRST_NOTIFY_RESPONSE);
                    Bundle bResp = new Bundle();
                    bResp.putString("respData", first_notify_data);// here you set the data you want to show
                    resp.setData(bResp);

                    msg.replyTo.send(resp);
                } catch (RemoteException e) {

                    e.printStackTrace();
                }
                break;
            }
            default: 
                super.handleMessage(msg);
            }
        }
}