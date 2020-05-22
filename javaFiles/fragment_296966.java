private RecyclerView rvCurrency;
private GridLayoutManager gridLayoutManager;
public AdapterCurrency adapterCurrency;
private List<Currency> currency;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_vertrage);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    rvCurrency = (RecyclerView) findViewById(R.id.rvCurrency);
    currency  = new ArrayList<>();


    gridLayoutManager = new GridLayoutManager(this,1);
    rvCurrency.setLayoutManager(gridLayoutManager);

    adapterCurrency = new AdapterVerträge(this,currency);
    rvCurrency.setAdapter(adapterCurrency);



}
}