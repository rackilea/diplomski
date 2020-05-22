public class MainActivity extends AppCompatActivity {

    TextView status,water,steam,inlet,outlet;
    String istatus,iwater,isteam,iinlet,ioutlet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // address the text
        status = findViewById(R.id.a);
        water = findViewById(R.id.b);
        steam = findViewById(R.id.c);
        inlet = findViewById(R.id.d);
        outlet = findViewById(R.id.e);

        final DatabaseReference ref 
        =FirebaseDatabase.getInstance().getReference().child("ESP32_SADS");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // your variables become have value then put it to your text
                istatus = dataSnapshot.child("Status").getValue().toString();
                iwater = dataSnapshot.child("Water").getValue().toString();
                isteam = dataSnapshot.child("Steam").getValue().toString();
                iinlet = dataSnapshot.child("Inlet").getValue().toString();
                ioutlet = dataSnapshot.child("Outlet").getValue().toString();

                // set values in textViews
                status.setText(istatus);
                water.setText(iwater);
                steam.setText(isteam);
                inlet.setText(iinlet);
                outlet.setText(ioutlet);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }



        });
    }