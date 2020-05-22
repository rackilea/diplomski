public class ChartsActivity extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_layout);

        barChart = (BarChart) findViewById(R.id.chart1);

        float yValues [] = {10, 20, 30, 40, 50};
        String xValues [] = {"first", "second", "third", "four", "five"};

        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        drawBarGraph(yValues,xValues);

    }

    private void drawBarGraph(float [] yValues, String [] xValues){
        ArrayList<BarEntry> yData = new ArrayList<>();
        for (int i = 0; i < yValues.length; i++){
            yData.add(new BarEntry(i,yValues[i]));
        }


        BarDataSet barDataSet = new BarDataSet(yData, "Cells");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        BarData barData =  new BarData(barDataSet);

        barData.setValueTextSize(13f);
        barData.setValueTextColor(Color.MAGENTA);

        barChart.getXAxis().setValueFormatter(new LabelFormatter(xValues));
        barChart.setData(barData);
        barChart.invalidate();
    }



    public class LabelFormatter implements IAxisValueFormatter {
        private final String[] mlabels;

        public LabelFormatter(String[] labels) {
            this.mlabels = mlabels;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mLabels[(int) value];
        }
    }
}