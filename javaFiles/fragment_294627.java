public class DatosSensor extends AppCompatActivity implements onLoopjTaskFinished {

    private onLoopjTaskFinished loopjListener;

    private DrawerLayout drawerLayout;

    ProgressDialog prgDialog;
    TextView errorMsg;
    private String temeperatura;

    ArrayList<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_datos_sensor);

        String idObjeto = (String) getIntent().getExtras().getSerializable("IdentidadEnviada");

        CaptarParametros(idObjeto);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        entries = new ArrayList<>();
        //entries.add(new Entry(60f, 0));
        //entries.add(new Entry(6f, 1));
        //entries.add(new Entry(6f, 2));
        //entries.add(new Entry(2f, 3));
        //entries.add(new Entry(18f, 4));
        //entries.add(new Entry(60f, 5));

        Log.i(UtilitiesGlobal.TAG, "onCreate: entries size = " + entries.size());

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();


        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);


        lineChart.setData(data);
        lineChart.animateY(5000);


        //Toast.makeText(getApplicationContext(), idObjeto, Toast.LENGTH_LONG).show();

        agregarToolbar();

    @Override
    public void onLoopjFinishedSuccess(JSONObject jsonObject) {
        List<String> allNames = new ArrayList<String>();
        JSONArray cast = null;
        try {
            cast = jsonObject.getJSONArray("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < cast.length(); i++) {
            JSONObject parametrosdht11 = null;
            String temperatura = null;
            String humedad = null;
            try {
                parametrosdht11 = cast.getJSONObject(i);
                temperatura = parametrosdht11.getString("temperatura");
                humedad = parametrosdht11.getString("humedad");
                allNames.add(temperatura);
                allNames.add(humedad);

                float tempFloat = Float.parseFloat(temperatura);
                entries.add(new Entry(tempFloat, i));

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Log.i(UtilitiesGlobal.TAG, "onSuccess: loopj " + usuarioiJSONbject);
            Log.i(UtilitiesGlobal.TAG, "onSuccess: loopj " + "temperatura: " + temperatura + " humedad: " + humedad);
        }
    }

Interface (onLoopjTaskFinished)

    public interface onLoopjTaskFinished {
    void onLoopjFinishedSuccess(JSONObject jsonObject);
    void onLoopjFinishedFailure(int statusCode);

}