protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    firebaseHandler = FirebaseHandler.getInstance();
    firebaseHandler.nameOfMember(new OnValueReadyListener() {
         public void onValueReady(String name, String surName) {
             // Do what you need here. you have the values ready
         }
    });

}