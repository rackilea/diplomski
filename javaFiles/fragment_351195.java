@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if(tabNumber == 1){
        setContentView(R.layout.fragment_layout1);
    }else if(tabNumber == 2){
        setContentView(R.layout.fragment_layout2);
    }else{
        setContentView(R.layout.fragment_layout3);
    }

}