private  DataSnapShot myDataSnapshot;
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.log_in_layout);

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           myDataSnapshot = dataSnapshot;
        }
    });

    init_views();
    button_click();


}