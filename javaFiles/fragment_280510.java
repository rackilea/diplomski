...
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_menu);
    ((MyFragment) getFragmentManager().findFragmentById(R.id.fragment)).setAdapter(mV);
    updateMovie();
}
...