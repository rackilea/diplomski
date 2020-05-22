public class AddressActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.spinner)
    Spinner countrySpinner;
    @BindView(R.id.spinner2)
    Spinner citiesSpinner;

    private Context context;
    private String apiHash;
    private List<String> countriesNameList = new ArrayList<>();
    private List<String> citiesNameList = new ArrayList<>();
    Map<String, List<String>> citiesNameMapWithCountry = new HashMap<>();
    private ArrayAdapter<String> dataAdapter;
    private ArrayAdapter<String> dataAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        context = this;
        ButterKnife.bind(this);
        apiHash = GoodPrefs.getInstance().getString(API_HASH, "");

        //Attach adapter to spinner here
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countriesNameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(dataAdapter);

        //Add listener here
        countrySpinner.setOnItemSelectedListener(this);

        //Set city spinner with adapter
        dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, citiesNameList);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citiesSpinner.setAdapter(dataAdapter2);


        callCitiesApi();
    }

    private void callCitiesApi() {
        ApiClient.Companion.getInstance().apisUseCase()
                .getCartCities(apiHash)
                .enqueue(new Callback<CartCitiesResponse>() {
                    @Override
                    public void onResponse(Call<CartCitiesResponse> call, Response<CartCitiesResponse> response) {
                        if (response.isSuccessful()) {
                            if (Objects.requireNonNull(response.body()).getStatus().equals("success")) {
                                for (int i = 0; i < response.body().getData().size(); i++) {
                                    String countryName = response.body().getData().get(i).getProvinces();
                                    countriesNameList.add(countryName);
                                    citiesNameMapWithCountry.put(countryName, response.body().getData().get(i).getCites());
                                }

                                //dataAdapter.clear();
                                //dataAdapter.addAll(countriesNameList);
                                dataAdapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<CartCitiesResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinner) {
            String countryName = (String) countrySpinner.getItemAtPosition(position);
            citiesNameList.clear();
            citiesNameList.addAll(citiesNameMapWithCountry.get(countryName));

            //dataAdapter2.clear();
            //dataAdapter2.addAll(citiesNameList);
            dataAdapter2.notifyDataSetChanged();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}