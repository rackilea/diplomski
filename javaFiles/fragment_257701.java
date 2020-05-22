public class MainActivity extends AppCompatActivity{

    private Context mContext;
    private Activity mActivity;
    private ArrayList<State> states;
    private ArrayList<City> cities;

    private StateSpinnerAdapter stateAdapter;
    private CitySpinnerAdapter cityAdapter;

   private Spinner spState, spCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
        initView();
        initListener();
    }

    private void initVariable() {
        mContext = getApplicationContext();
        mActivity = MainActivity.this;


        states = new ArrayList<>();
        cities = new ArrayList<>();
    }
    private void initView() {
        setContentView(R.layout.activity_main);
        spState = findViewById(R.id.spState);
        spCity = findViewById(R.id.cityState);

        stateAdapter = new StateSpinnerAdapter(mContext,states);
        spState.setAdapter(stateAdapter);

        cityAdapter = new CitySpinnerAdapter(mContext,cities);
        spCity.setAdapter(cityAdapter);

        loadStateData();

    }

    private void initListener(){
        spState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadCityData(states.get(i).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void loadStateData(){
       states.add(new State(1,"state 1"));
       states.add(new State(2,"state 1"));
       states.add(new State(3,"state 1"));
       states.add(new State(4,"state 1"));
       stateAdapter.notifyDataSetChanged();

    }

    private loadCityData(int stateId){
       ArrayList<City> cityList= new ArrayList<>();
       cityList.add(new City(1,"City 1", 1));
       cityList.add(new City(2,"City 2", 1));
       cityList.add(new City(3,"City 3", 2));
       cityList.add(new City(4,"City 4", 2));
       cityList.add(new City(5,"City 5", 3));
       cityList.add(new City(6,"City 6", 3));
       cityList.add(new City(7,"City 7", 4));
       cityList.add(new City(8,"City 8", 4));

       cities.addAll(cityList.stream().filter(city -> city.getStateId == stateId).collect(Collectors.toList()));
       cityAdapter.notifyDataSetChanged();

    }

}