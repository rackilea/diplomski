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
    }
    public double ReadSingleContact(int x ) {
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
                   //value dose not changed ??!
                    tt = 22;
                    runOnUiThread(new Runnable() {
                         void run() {
                             txtv.setText(tt+"A");
                             txtv.setText(lat+","+lng);
                         }
                    });
                }
            }
        });
        return tt;
    }
}