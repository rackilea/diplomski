@Override    
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       BarChart chart = this;

       BarData data = new BarData(getXAxisValues(), getDataSet());
       chart.setData(data);
       chart.setDescription("My Chart");
       chart.animateXY(2000, 2000);
       chart.invalidate();
       setContentView(chart);  
    }