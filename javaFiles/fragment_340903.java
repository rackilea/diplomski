ArrayList<String> products;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //creazione fullscreen activity
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.gruppipuntate_activity);

    //rimozione action bar
    if (Build.VERSION.SDK_INT < 11){
        getSupportActionBar().hide(); 
    }
    //gestione Switch java per selezione puntate
    final OnClickListener listener = new OnClickListener() {
         public void onClick(View v){
                int index = -1;
                switch(v.getId()){ 
                case R.id.button1:
                index = products.indexOf("Product1");
                    if(index >= 0)
                        products.remove(index);
                    break;
                case R.id.button2:
                    index = products.indexOf("Product2");
                    if(index >= 0)
                        products.remove(index);
                    break;
                case R.id.button3:
                    break;
                case R.id.button4:
                    break;
                case R.id.button5:
                    break;
                case R.id.button6:
                    break;
                case R.id.button7:
                    break;
                case R.id.button8:
                    break;
                case R.id.button9:
                    break;
                case R.id.button10:
                    break;
             }
         }
    };
    final int[] btnIds = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4
            , R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10};
    for(int i = 0; i < btnIds.length; i++) {
        final Button puntate = (Button)findViewById(btnIds[i]);
        puntate.setOnClickListener(new OnClickListener() {
            //preparazione intent
            public void onClick(View arg0) {

                Intent episodi = new Intent(GruppiPuntateActivity.this,EpisodiActivity.class);
                episodi.putStringArrayListExtra("products", products);
                startActivity(episodi);
        }
    });

}

protected void onResume() {
    super.onResume();

    products = new ArrayList<String>();
    products.add("Product1");
    products.add("Product2");
    products.add("Product3");
    products.add("Product4");
    products.add("Product5");
    products.add("Product6"); 
}