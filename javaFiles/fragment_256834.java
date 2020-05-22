public class RecyclerViewActivity extends AppCompatActivity {


    private  final Integer[] IMAGES = {R.drawable.nilesh, R.drawable.nilesh, R.drawable.nilesh, R.drawable.nilesh,
            R.drawable.nilesh, R.drawable.nilesh, R.drawable.nilesh, R.drawable.nilesh};
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Collections.addAll(arrayList, IMAGES);

        myRecyclerView=findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false));
        myRecyclerView.addItemDecoration(new OverlapDecoration());
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter(new DataAdapter(this,arrayList));


    }

    public class OverlapDecoration extends RecyclerView.ItemDecoration {

        private final static int vertOverlap = -40;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            final int itemPosition = parent.getChildAdapterPosition(view);


            outRect.set(0, 0, vertOverlap, 0);


        }
    }
}