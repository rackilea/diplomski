private globalAdapter adpt;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.loading);
    adpt  = ((globalAdapter)getApplicationContext());
    ...
}