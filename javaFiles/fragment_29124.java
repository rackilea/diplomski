public class StackFragment extends Fragment {

    ListView listview_forecast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stack, container, false);

        listview_forecast = (ListView) view.findViewById(R.id.listview_forecast);

        String forecastArray[] = {
                "Today - Sunny - 88/63",
                "tom - Sunny - 88/63",
                "day after - Cyclone - 88/63",
                "another day - Tornadoes - 88/63",
                "One another day - Sunny - 88/63",
                "Next day - Sunny - 88/63",
                "again, next day - Sunny - 88/63"

        };

        List<String> weekForecast = new ArrayList<>(
                Arrays.asList(forecastArray)
        );

        ArrayAdapter mForecastAdapter = new ArrayAdapter(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);
        listview_forecast.setAdapter(mForecastAdapter);

        return view;

    }
}