protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(ConnectDotsView)findViewById(R.id.dot);
        List<Point> point=new ArrayList<Point>();
        for(int i=0;i<5;i++){
            point.add(new Point(i*100+100, i*100+10));
        }
        view.setPoints(point);
    }