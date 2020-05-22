import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;



public class SampleCode extends AppCompatActivity {

    private final String NAMESPACE = "http://ws.mkyong.com/";
    private final String SOAP_ACTION = "\"http://ws.mkyong.com/getHelloWorldAsString\"";
    private final String METHOD_NAME = "getHelloWorldAsString";
    private final String URL_App = "http://localhost:8080/JAX-WS-Application-Authentication-Example/HelloWorldImplService?WSDL";

    String TAG = "Repsonse";
    String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_path);

        Button btnClick = (Button) findViewById(R.id.btnClick2);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncCallWS().execute();
            }
        });
    }

    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            sendHeader();
            return null;
        }
    }


    private void sendHeader(){

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = false;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL_App);
        try{
            envelope.setOutputSoapObject(request);

            List<HeaderProperty> headerList = new ArrayList<HeaderProperty>();
            headerList.add(new HeaderProperty("Username", "mkyong"));
            headerList.add(new HeaderProperty("Password", "password"));

            androidHttpTransport.call(SOAP_ACTION, envelope, headerList);

            SoapPrimitive resultString = (SoapPrimitive) envelope.getResponse();


            Boolean status = Boolean.valueOf(resultString.toString());

            Log.i(TAG, "Result : " + resultString );

        }catch (Exception ex) {
            Log.e(TAG, "Exception: " + ex);
            response = "Exception";
        }
    }
}