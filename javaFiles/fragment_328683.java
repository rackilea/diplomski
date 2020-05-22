import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecetarionDanica extends Activity 
{
    /** Called when the activity is first created. */
    private static String SOAP_ACTION = "http://danica.com.ar/recetario/Registration";
    //private static String SOAP_ACTION2 = "http://www.w3schools.com/webservices/CelsiusToFahrenheit";
    private static String NAMESPACE = "http://danica.com.ar/recetario";
    private static String METHOD_NAME = "Registration";
    //private static String METHOD_NAME2 = "CelsiusToFahrenheit";
    private static String URL = "http://danica.com.ar/cgi-bin/soapserver.pl";

    Button btnReg;
    EditText fullName,emailId,password,confirmPwd;
    String result="";

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_main);

        btnReg = (Button)findViewById(R.id.regId);
        fullName = (EditText)findViewById(R.id.name);
        emailId = (EditText)findViewById(R.id.emailId);
        password = (EditText)findViewById(R.id.pwd);
        confirmPwd = (EditText)findViewById(R.id.pwd1);

        btnReg.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
                //Initialize soap request + add parameters
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);                
                Log.d("request", request.toString());
                //Use this to add parameters
                User user = new User();

                user.setEmail(""+emailId.getText().toString().trim());
                user.setFirstName(""+fullName.getText().toString().trim());
                user.setPassword(""+password.getText().toString().trim());
                user.setGplusId(" ");//(""+fullName.getText().toString().trim());
                user.setTweet(" ");//(""+fullName.getText().toString().trim());
                user.setLastName(" ");//(""+fullName.getText().toString().trim());
                user.setFacebookId(" ");//(""+fullName.getText().toString().trim());

                request.addProperty("user", user);

//              request.addProperty("email",emailId.getText().toString().trim());
//              request.addProperty("firstName",fullName.getText().toString().trim());              
//              request.addProperty("password",password.getText().toString().trim());
                Log.d("request 2", request.toString());
                //Declare the version of the SOAP request
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

                envelope.setOutputSoapObject(request);  
                //envelope.addMapping(NAMESPACE, "user", new User.getClass());

                Log.d("envelope", envelope.toString());

                try {

                    Log.d("TRY Block", "TRY");
                    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                    Log.d("androidHttpTransport", androidHttpTransport.toString());
                    //this is the actual part that will call the webservice
                    androidHttpTransport.call(SOAP_ACTION, envelope);

                    Log.d("---Block---", "Block 2");

                    SoapObject result = null;
                    if (envelope.bodyIn instanceof SoapFault) {
                        String str= ((SoapFault) envelope.bodyIn).faultstring;
                        Log.i("Fault", str);

                    } else {
                        // Get the SoapResult from the envelope body.               
                        result = (SoapObject)envelope.bodyIn;
                        Log.d("WS", String.valueOf(result));
                    }

                    if(result != null)
                    {
                        //Get the first property and change the label text
                        Log.d("If result not null", String.valueOf(result));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No Response",Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });        

    }
}