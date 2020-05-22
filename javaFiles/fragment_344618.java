private Button B1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    B1 = (Button)findViewById(R.id.btn1);

    B1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            FragmentOne f = (FragmentOne) fm.findFragmentByTag("tag");

            if(f == null) {  // not added
                f = new FragmentOne();
                ft.add(R.id.frg1, f, "tag");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            } else {  // already added

                ft.remove(f);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            }

            ft.commit();
        }
    });

    // and so on ...
}