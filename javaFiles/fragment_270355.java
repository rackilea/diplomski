@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubkampioenschappen_singleen_dubbel);
        this.setTitle("Onderdelen");

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            ListView Onderdelen = (ListView) findViewById(R.id.Onderdelen);
            ClubkampioenschappenOnderdelenHTMLRequest clucka = new ClubkampioenschappenOnderdelenHTMLRequest(list, ClubkampioenschappenSingleenDubbelOnderdelen.this, Onderdelen);
            clucka.execute();