@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    Bundle args = getArguments();
    dayForecast = (DayForecast) args.getSerializable("object");

    View rootView = inflater.inflate(R.layout.forecast_fragment, container, true);
    ListView weatherLV = (ListView) rootView.findViewById(R.id.weather_list);
    weatherLV.setAdapter(new WeatherAdapter(inflater, dayForecast.getConditions()));
    return rootView;
}