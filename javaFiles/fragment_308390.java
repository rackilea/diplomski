@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campus); 
        setSize();
        this.mapv = findViewById(R.id.mapView); //!! my view 
        i= new Intent(this, myService.class);
        this.startService(i); 
}