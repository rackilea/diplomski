public class SalesHistoryActivity extends AppCompatActivity {

    @BindView(R.id.sales_recycler)
    RecyclerView recyclerView;

    ..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_history);

        ButterKnife.bind(this);

        // now your views are binded. You can access them

        ...

        recyclerView.setHasFixedSize(true);

        ...

    }

}