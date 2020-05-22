public class SmsReceiver extends BroadcastReceiver {
    public interface OnCustomReceiveSMS {
        void OnReceiveSMS(String inNumber, String inText);
    }
    public OnCustomReceiveSMS SMSListener;

    //constructor
    public SmsReceiver(OnCustomReceiveSMS eventListener){
        this.SMSListener = eventListener;
        this.SMSListener.OnReceiveSMS("test1", "test2");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
         //THIS IS ALWAYS FALSE EVEN AFTER INITIALIZED
         if(this.SMSListener != null){
            Toast.makeText(context, "SMSListener is NOT null", Toast.LENGTH_SHORT).show();
            this.SMSListener.OnReceiveSMS("test3", "test4");
         }else{
            Toast.makeText(context, "SMSListener is NULL", Toast.LENGTH_SHORT).show();
         }
    }
}