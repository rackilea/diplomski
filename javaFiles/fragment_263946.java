public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL, false);

        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(myAdapter);

        // This is how you will populate the recycler view

        String START_TIME  = "7:00";
        String END_TIME = "22:00";

        char first = START_TIME.charAt(0);

        int StartTimeint = Integer.parseInt(String.valueOf(first));

        int l;
        for( l = StartTimeint; l<=22; l++){

            // This is where new item are added to recyclerView.
            myAdapter.addItem(l + ":00");

        }

    }
}