public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        List<Model> list = new ArrayList<>();
        list.add(new Model("top-one", "bot-one"));
        list.add(new Model("top-two", "bot-two"));
        list.add(new Model("top-three", "bot-three"));
        list.add(new Model("top-four", "bot-four"));
        list.add(new Model("top-five", "bot-five"));
        list.add(new Model("top-six", "bot-six"));
        list.add(new Model("top-seven", "bot-seven"));
        list.add(new Model("top-eight", "bot-eight"));

        ListAdapter adapter = new ListAdapter(listview.getContext(), list);
        listview.setAdapter(adapter);
    }
}