public class MainActivity extends AppCompatActivity {
    //Always create a TAG it is very useful when logging to the logcat!
    private static final String TAG = MainActivity.class.getSimpleName();

    //Not used! Not needed!
    //RequestQueue rq = null;

    // I like to have all my class variables defined at the beginning--even if it is just null!
    //Class variable to hold the object throughout the class!
    Spinner toSpinner = null;
    Spinner fromSpinner = null;
    Button convertBtn = null;

    //Class variable to hold the object throughout the class!
    EditText fromAmountEditText = null;
    TextView toAmountTextView = null;

    String toSpinnerText = "";
    String fromSpinnerText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinnerAddData();

        // convertBtn is a class variable defined above--do not create a local variable here
        convertBtn = (Button) findViewById(R.id.convertBtn);

        // fromAmountEditText is a class variable defined above--do not create a local variable here
        fromAmountEditText = findViewById(R.id.fromAmountEditText);
        // toAmountTextView is a class variable defined above--do not create a local variable here
        toAmountTextView = findViewById(R.id.toAmountTextView);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Perform your request here--after the currencies have been selected!
                jsonSendRequest();
            }
        });
        //Dont use it--Dont need it!
        //rq = Volley.newRequestQueue(this);
    }

    // this does not need to be public!
    private void jsonSendRequest() {

        RequestQueue queue = Volley.newRequestQueue(this);
        // String url = "http://free.currencyconverterapi.com/api/v3/convert?q=CAD_USD&compact=ultra";
        String url = "http://free.currencyconverterapi.com/api/v3/convert?q=" + fromSpinnerText + "_" + toSpinnerText  + "&compact=ultra";

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //onResponse is asynchronous it is called when the data is available, but it executes on the UI thread 
                        JSONObject jsonobject = null;
                        try {
                            jsonobject = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (jsonobject.has(fromSpinnerText + "_" + toSpinnerText)) {
                            try {
                                //conversionDouble is only used here so it can be a local variable!
                                Double conversionDouble = jsonobject.getDouble(fromSpinnerText + "_" + toSpinnerText);
                                // conversionDouble = jsonobject.getDouble(fromSpinnerText + "_" + toSpinnerText);

                                //now the data has returned from the async request and is ready to be used..
                                //...do the conversion, now!
                                DecimalFormat percentageFormat = new DecimalFormat("0.00");
                                Double fromAmount = Double.parseDouble(fromAmountEditText.getText().toString());
                                String result = "$" + percentageFormat.format(conversionDouble*fromAmount);
                                toAmountTextView.setText(result);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    // this does not need to be public!
    private void createSpinnerAddData(){

        //The spinners were already defined in the onCreate method--please do not create local variables!!
        //Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);
        //Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);

        // fromSpinner is a class variable defined above--do not create a local variable here
        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        // toSpinner is a class variable defined above--do not create a local variable here
        toSpinner = (Spinner) findViewById(R.id.toSpinner);

        List<String> currency = new ArrayList<String>();
        currency.add("USD");
        currency.add("CAD");
        currency.add("CNY");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currency);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 

        toSpinner.setAdapter(dataAdapter);
        fromSpinner.setAdapter(dataAdapter);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //This has also been defined as a class variable--please do not create local variable!!
                //String fromSpinnerText = (String) parent.getItemAtPosition(position);
                //...Instead use the class variable
                fromSpinnerText = (String) parent.getItemAtPosition(position);
                Log.e(TAG, "fromSpinnerText = " + fromSpinnerText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Same principle as above
                toSpinnerText = (String) parent.getItemAtPosition(position);
                Log.e(TAG, "toSpinnerText = " + toSpinnerText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}