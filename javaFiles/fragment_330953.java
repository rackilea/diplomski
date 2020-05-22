protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin_control);
    Toolbar b = (Toolbar) findViewById(R.id.toolbar);
    b.setTitle("Tournaments");
    setSupportActionBar(b);
    ref = AdminLogin.firebase.child("users").child(AdminLogin.firebase.getAuth().getUid());
    if (tournaments == null){
        tournaments = new ArrayList<>();
    }

    FloatingActionButton myFab = (FloatingActionButton)findViewById(R.id.fab); 
    myFab.setOnClickListener(new View.OnClickListener() { 
        public void onClick(View v) { 
            createNewTournament(v); 
        } 
    });
}