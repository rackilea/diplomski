Button f;
TextView status;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    f = (Button)findViewById(R.id.button);
    status = (TextView) findViewById(R.id.lightstatus);

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef   = database.getReference("light");

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Integer value = dataSnapshot.getValue(Integer.class);
            status.setText(String.valueOf(value));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError){
            status.setText("Could not fetch data..");
        }
    });
}

public void lighton(View view){
    myRef.setValue(1);
}

public void lightoff(View view){
    myRef.setValue(0);
  }

}