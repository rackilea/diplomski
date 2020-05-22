public class MyIntentService extends IntentService {

    public MyIntentService(){
    super("Service Name");
    }

    @Override
    protected void onHandleIntent(Intent intent){
        Command command = (Command)intent.getParcelableExtra("command");
        command.execute();

    }

}