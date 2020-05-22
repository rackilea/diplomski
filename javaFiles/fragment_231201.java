public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    TextView  txtv;
    double tt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        txtv = (TextView) findViewById(R.id.txt);
        //txtv.setText(ReadSingleContact(1)+"A");
        //Here you can call the function and implement the interface method that'll get called once the values for lat & lng are calculated
        ReadSingleContact(1, new CustomCallback() {
            @Override
            public void onComplete(double lat, double lng) {
                //here you can implement your required code
                //which can be changed based on what calls this method
                txtv.setText(lat+"A");
                //P.S - At this point, the value of tt would have been changed, since the `onComplete` method gets called after the value of tt is changed.
            }
        });
    }
    public void ReadSingleContact(int x, CustomCallback customCallback) {
        String num = Integer.toString(x);
        DocumentReference contact = db.collection("MAPS").document(num);
        contact.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task ) {
                if(task.isSuccessful()){
                    DocumentSnapshot doc = task.getResult();
                    /*
                    StringBuilder data = new StringBuilder("");
                    data.append("name: ").append(doc.getString("name"));
                    data.append("\nlatitude: ").append(doc.getString("latitude"));
                    data.append("\nlongtude: ").append(doc.getString("longtude"));
                    */
                    GeoPoint geoPoint = doc.getGeoPoint("latitude");
                    double lat = geoPoint.getLatitude();
                    double lng = geoPoint.getLongitude();
                    tt = 22;
                    //Call customCallback.onComplete at the end
                    if (customCallback != null) {
                        customCallback.onComplete(lat,lng);
                    }
                }
            }
        });
    }
}