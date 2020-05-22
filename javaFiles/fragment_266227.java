Using Ksoap2 library and write .net web service 
Sucessful Connection with Asp.net Webservice-----
package ProductVerificationCard.in;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AdminLogin extends Activity {
    /** Called when the activity is first created. */
    Button btn_ok;
    TextView textView;
    private static final String SOAP_ACTION = "http://tempuri.org/Login";

    private static final String OPERATION_NAME = "Login";

    private static final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    private static final String SOAP_ADDRESS = "http://10.0.2.2/new/WebService.asmx";
    String s;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn_ok=(Button) findViewById(R.id.btn_login);
        textView=(TextView) findViewById(R.id.tv_error);

        btn_ok.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
                        OPERATION_NAME);

                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                        SoapEnvelope.VER11);
                        envelope.dotNet = true;

                        envelope.setOutputSoapObject(request);

                        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);

                        try

                        {

                        httpTransport.call(SOAP_ACTION, envelope);

                        Object response = envelope.getResponse();

                        //textView.setText(response.toString());
                         s=response.toString();
                         if(s=="true")
                         {
                             Intent intent=new Intent(AdminLogin.this,MenuForm.class);
                                startActivity(intent);

                         }

                         else
                         {
                             textView.setText("Enter Valid Username or Password");
                         }
                        }

                        catch (Exception exception)

                        {

                        textView.setText(exception.toString());

                        }
                // TODO Auto-generated method stub
                }
        });

    }
}