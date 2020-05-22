public class MainActivity extends Activity{

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.Yourlayout);

    CallList calls =  CallRetriever.getAllCalls("ACCOUNT_SID_value","AUTH_TOKEN_value");
    //calls contains the final result
     for (Call call : calls) {
        System.out.println("From: " + call.getFrom() + " To: " + call.getTo());
    }
 } 
}