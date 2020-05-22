DatabaseReference driverRef = FirebaseDatabase.getInstance().getReference().child("bname");

                                    driverRef.removeValue();

    if you delete whole database
    use this

      DatabaseReference driverRef = FirebaseDatabase.getInstance().getReference();
    driverRef.removeValue();

//---------------------Use on Button click Listener--------

        setContentView(R.layout.activity_main);
Button button=findViewById(R.id.btn);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        DatabaseReference driverRef = FirebaseDatabase.getInstance().getReference().child("bname");

        driverRef.removeValue();
    }
});