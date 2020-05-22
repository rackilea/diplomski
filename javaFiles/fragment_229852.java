public class SecondActivity extends AppCompatActivity {
    ListView lv;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) findViewById(R.id.list);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String city = intent.getStringExtra("city");

        Model model = new Model();
        model.setCity(city);
        model.setName(name);

        ArrayList<Model> listModel = new ArrayList<>();
        listModel.add(model);

        myAdapter = new MyAdapter(listModel, this);
        lv.setAdapter(myAdapter);
    }
}