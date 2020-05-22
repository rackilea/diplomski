public class DatosSensor extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private static final String SENSORS_URL = "http://.....";

    // Progress Dialog Object
    ProgressDialog prgDialog;
    // Error Msg TextView Object
    TextView errorMsg;
    // Email Edit View Object

    private String temeperatura;

    ArrayList<Entry> temperature = new ArrayList<>();
    ArrayList<Entry> yVals2 = new ArrayList<>();

    LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_datos_sensor);
        String idObjeto = (String) getIntent().getExtras().getSerializable("IdentidadEnviada");

        CaptarParametros(idObjeto);

        mChart = (LineChart) findViewById(R.id.chart);

        // no description text
        mChart.setDescription("");
        mChart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable touch gestures
        mChart.setTouchEnabled(true);

        mChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(true);

        // set an alternative background color
        mChart.setBackgroundColor(Color.LTGRAY);

        mChart.animateX(2500);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTextSize(11f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMaxValue(100f);
        xAxis.setAxisMinValue(0f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);

        //modify leftYaxis range similarly others
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
        leftAxis.setAxisMaxValue(100f);
        leftAxis.setAxisMinValue(0f);
        leftAxis.setDrawGridLines(false);
        leftAxis.setGranularityEnabled(true);


        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setTextColor(Color.RED);
        rightAxis.setAxisMaxValue(100f);
        rightAxis.setAxisMinValue(0f);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);


        // add data
        setData();
    }


    private void CaptarParametros(String idObjeto) {

        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put(UtilitiesGlobal.SENSOR_ID, idObjeto);

        RequestHandle post = client.post(this, SENSORS_URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                JSONObject jsonobject = null;
                JSONObject dht11JSONbject = null;
                JSONArray dht11JSONarray = null;


                try {

                    jsonobject = new JSONObject(String.valueOf(response));
                    //dht11JSONbject = jsonobject.getJSONObject("result");


                    List<String> allNames = new ArrayList<String>();
                    JSONArray cast = jsonobject.getJSONArray("result");
                    for (int i=0; i<cast.length(); i++) {
                        JSONObject parametrosdht11 = cast.getJSONObject(i);
                        String temperatura = parametrosdht11.getString("temperatura");
                        String humedad = parametrosdht11.getString("humedad");
                        temperature.add(new Entry(Float.valueOf(i),Float.valueOf(temperatura)));
                        yVals2.add(new Entry(Float.valueOf(i),Float.valueOf(humedad)));

                        //rrefresh
                        mChart.notifyDataSetChanged();
                        //Log.i(UtilitiesGlobal.TAG, "onSuccess: loopj " + usuarioiJSONbject);
                        Log.i(UtilitiesGlobal.TAG, "onSuccess: loopj " +"temperatura: "+ temperatura +" humedad: " +humedad);
                    }

    private void setData() {
//data set represents a lin
        LineDataSet set1, set2;

        // create a dataset and give it a type
        //modifications with colour and stuf
        set1 = new LineDataSet(temperature, "Temperatur");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setCircleColor(Color.WHITE);
        set1.setLineWidth(2f);
        set1.setCircleRadius(3f);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);


        // similar above
        set2 = new LineDataSet(yVals2, "Humidity");
        set2.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set2.setColor(Color.RED);
        set2.setCircleColor(Color.WHITE);
        set2.setLineWidth(2f);
        set2.setCircleRadius(1f);
        set2.setFillAlpha(65);
        set2.setFillColor(Color.RED);
        set2.setDrawCircleHole(false);
        set2.setHighLightColor(Color.rgb(244, 117, 117));
        //set2.setFillFormatter(new MyFillFormatter(900f));

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets
        dataSets.add(set2);

        // create a data object with the datasets
        LineData data = new LineData(dataSets);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(9f);

        // set data
        Log.i("Lists Sizedata",temperature.size() + " and " + yVals2.size());
        mChart.setData(data);
    }
}