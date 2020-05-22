public class StackActivity extends AppCompatActivity {

private String TAG = StackActivity.class.getSimpleName();
Spinner spinnerStack;
List <StackHelper> stackHelperList = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_stack);
    spinnerStack = findViewById(R.id.spFrom);
    spin();

    spinnerStack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
            String selling = ((StackHelper) spinnerStack.getSelectedItem ()).getSelling ();
            String buying = ((StackHelper) spinnerStack.getSelectedItem ()).getBuying ();
            String median = ((StackHelper) spinnerStack.getSelectedItem ()).getMedian ();
            String value = ((StackHelper) spinnerStack.getSelectedItem ()).getValue ();
            Toast.makeText(StackActivity.this,
                    "Selling : " + selling+"\n" +
                            "Buying : " + buying+"\n" +
                            "Median : " + median+"\n" +
                            "Value : " + value, Toast.LENGTH_SHORT).show();
        }
        public void onNothingSelected(AdapterView<?> arg0) { }
    });
}

private void spin () {
    stackHelperList = new ArrayList<>();

    try {
        String jsonStr = "[{\"unit_value\": 1, \"median_rate\": \"4.656778\", \"currency_code\": \"AUD\", \"buying_rate\": \"4.642808\", \"selling_rate\": \"4.670748\"}, {\"unit_value\": 1, \"median_rate\": \"4.811651\", \"currency_code\": \"CAD\", \"buying_rate\": \"4.797216\", \"selling_rate\": \"4.826086\"}, {\"unit_value\": 1, \"median_rate\": \"0.290560\", \"currency_code\": \"CZK\", \"buying_rate\": \"0.289688\", \"selling_rate\": \"0.291432\"}, {\"unit_value\": 1, \"median_rate\": \"0.994420\", \"currency_code\": \"DKK\", \"buying_rate\": \"0.991437\", \"selling_rate\": \"0.997403\"}, {\"unit_value\": 100, \"median_rate\": \"2.356911\", \"currency_code\": \"HUF\", \"buying_rate\": \"2.349840\", \"selling_rate\": \"2.363982\"}, {\"unit_value\": 100, \"median_rate\": \"5.677144\", \"currency_code\": \"JPY\", \"buying_rate\": \"5.660113\", \"selling_rate\": \"5.694175\"}, {\"unit_value\": 1, \"median_rate\": \"0.767955\", \"currency_code\": \"NOK\", \"buying_rate\": \"0.765651\", \"selling_rate\": \"0.770259\"}, {\"unit_value\": 1, \"median_rate\": \"0.701279\", \"currency_code\": \"SEK\", \"buying_rate\": \"0.699175\", \"selling_rate\": \"0.703383\"}, {\"unit_value\": 1, \"median_rate\": \"6.204487\", \"currency_code\": \"CHF\", \"buying_rate\": \"6.185874\", \"selling_rate\": \"6.223100\"}, {\"unit_value\": 1, \"median_rate\": \"8.395712\", \"currency_code\": \"GBP\", \"buying_rate\": \"8.370525\", \"selling_rate\": \"8.420899\"}, {\"unit_value\": 1, \"median_rate\": \"6.194629\", \"currency_code\": \"USD\", \"buying_rate\": \"6.176045\", \"selling_rate\": \"6.213213\"}, {\"unit_value\": 1, \"median_rate\": \"3.787414\", \"currency_code\": \"BAM\", \"buying_rate\": \"3.776052\", \"selling_rate\": \"3.798776\"}, {\"unit_value\": 1, \"median_rate\": \"7.407537\", \"currency_code\": \"EUR\", \"buying_rate\": \"7.385314\", \"selling_rate\": \"7.429760\"}, {\"unit_value\": 1, \"median_rate\": \"1.736169\", \"currency_code\": \"PLN\", \"buying_rate\": \"1.730960\", \"selling_rate\": \"1.741378\"}]";

        JSONArray jsonArray = null;
        jsonArray = new JSONArray(jsonStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            String code = jsonobject.getString("currency_code");
            String selling = jsonobject.getString("selling_rate");
            String buying = jsonobject.getString("buying_rate");
            String median = jsonobject.getString("median_rate");
            String value = jsonobject.getString("unit_value");

            StackHelper stackHelper = new StackHelper();
            stackHelper.setCode(code);
            stackHelper.setSelling(selling);
            stackHelper.setBuying(buying);
            stackHelper.setMedian(median);
            stackHelper.setValue(value);
            stackHelperList.add(stackHelper);

        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
    ArrayAdapter<StackHelper> dataAdapter = new ArrayAdapter<StackHelper>(this,
            android.R.layout.simple_selectable_list_item,stackHelperList);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerStack.setAdapter(dataAdapter);

}}