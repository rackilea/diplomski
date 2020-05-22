public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grcade);

        if (savedInstanceState != null)
        {
            web.loadUrl(webURL);
        }
.........
.........