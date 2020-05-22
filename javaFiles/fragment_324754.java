public class MainActivity extends Activity {

String ans[] ={"","",""};
String Icao ="";
String url ;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

   Icao = "WSSS";   
   url = String.format("http://flightxml.flightaware.com/json/FlightXML2/Search?query=-destination%%20%s",Icao);

  btn1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
        getInput(url);  
        txt1.setText(ans[0]);

    } });
    }