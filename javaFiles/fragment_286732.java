@Override    
     protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(layout.xml);

           BarChart chart = (BarChart) findViewById(R.id.chart);

           BarData data = new BarData(getXAxisValues(), getDataSet());
           chart.setData(data);
           chart.setDescription("My Chart");
           chart.animateXY(2000, 2000);
           chart.invalidate();
     }