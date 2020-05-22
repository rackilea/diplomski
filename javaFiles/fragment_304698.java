protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ScrollView svv = new ScrollView(this);
    svv.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.WRAP_CONTENT));
    LinearLayout linLayout = new LinearLayout(this);
    linLayout.setOrientation(LinearLayout.VERTICAL);
    LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    int colcount = 20;
    int rowcount = 1;
    TextView tv;
    Button btn;
    GridLayout grd;
    GridLayout.LayoutParams gllop;
    HorizontalScrollView svh;

    for(int i = 0; i < 30; i++) {
    tv= new TextView(this);
    tv.setText("TextView " + i);
    tv.setLayoutParams(lpView);
    linLayout.addView(tv);
    grd = new GridLayout(this);
    grd.setColumnCount(colcount);
    grd.setRowCount(rowcount);
    grd.setBackgroundColor(Color.YELLOW);
        for(int j = 0; j < 20; j++) {
            gllop = new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(j));
            btn = new Button(this);
            btn.setText("Button " + i +"."+j);
            grd.addView(btn, gllop);
        }
        svh = new HorizontalScrollView(this);
        svh.addView(grd);
        linLayout.addView(svh);
    }
    svv.addView(linLayout);
    setContentView(svv, linLayoutParam);

}