@Override
        protected void onCreate(Bundle savedInstanceState)
        {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            pc = findViewById(R.id.chart);
            BottomNavigationView navigation = findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            ArrayList <PieEntry> pieData = new ArrayList<>();
            pieData.add(new PieEntry(10));
            pieData.add(new PieEntry(20));
            pieData.add(new PieEntry(30));
            PieDataSet dataSet = new PieDataSet(pieData, "Survey Results");
            PieData data = new PieData(dataSet);
            pc.setData(data);
        }