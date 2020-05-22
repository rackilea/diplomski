UpdTextViewReceiver updTextViewReceiver;
public class UpdTextViewReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if(action.equalsIgnoreCase(EXTRA_MESSAGE)){  
            String message = intent.getStringExtra("Message")
            MainActivity.updateTextView(message);
        }
   }

}  

private void updateTextView(String message){

    //Update the TextView here
}