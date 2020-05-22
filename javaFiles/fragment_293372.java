EditText listInput;
    Button listButton;
    ListView listView;
    ArrayAdapter arrayAdaptor;
    List<String> names = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listInput = (EditText)findViewById(R.id.listInput);
        listButton = (Button)findViewById(R.id.listButton);
        listView = (ListView)findViewById(R.id.listView);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNames();
                if(arrayAdaptor == null){
                arrayAdaptor = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
                listView.setAdapter(arrayAdaptor);
                }else{
                arrayAdaptor.notifyDataSetChanged();
                }
            }
        });
    }
    public void addNames(){
        String name = listInput.getText().toString();
        names.add(name);
        Log.d("Entered text is" ,name);
    }
}