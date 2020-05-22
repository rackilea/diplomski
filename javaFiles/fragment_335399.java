import org.zoolu.sip.address.NameAddress;
import org.zoolu.sip.message.Message;
import org.zoolu.sip.message.MessageFactory;
import org.zoolu.sip.provider.SipProvider;
import org.zoolu.sip.provider.SipStack;
import org.zoolu.sip.transaction.TransactionClient;
import org.zoolu.sip.transaction.TransactionClientListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements TransactionClientListener{

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new Thread(new Runnable(){

        @Override
        public void run() {
            try{
                SipStack.init();

                SipProvider sipProvider = new SipProvider(
                        "192.168.0.198", 5060, new String[]{"udp"}, null);
                NameAddress toAddress = new NameAddress(
                        "sip:192.168.0.195:9876");
                NameAddress fromAddress = new NameAddress(
                        "sip:192.168.0.198:9876");

                Message message = MessageFactory.createRegisterRequest(
                        sipProvider, 
                        toAddress, 
                        fromAddress, 
                        fromAddress, 
                        null, 
                        null);

                TransactionClient t = new TransactionClient(
                        sipProvider, 
                        message,
                        MainActivity.this);

                t.request();

            }catch(Exception e){
                Log.d("MYSIP", Log.getStackTraceString(e));
            }
        }}).start();
}

// Interface methods

}