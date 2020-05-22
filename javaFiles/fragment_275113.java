@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // On récupère toutes les vues dont on a besoin
    logo = (ImageButton)findViewById(R.id.logo);
    boutonPortail = (ImageButton)findViewById(R.id.boutonPortail);