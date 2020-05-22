public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RetriveDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rvData);
        rvData.setHasFixedSize(true);
        rvData.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.child("Post").addValueEventListener(new ValueEventListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<MyBean> arrayList = new ArrayList<MyBean>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    MyBean bean = noteDataSnapshot.getValue(MyBean.class);
                    arrayList.add(bean);
                }
                Log.e("MainActivity.this", "Data list ::>>>>>" + arrayList.size());
                adapter = new RetriveDataAdapter(MainActivity.this, arrayList);
                rvData.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}