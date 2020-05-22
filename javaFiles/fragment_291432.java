public class ForecastFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        ......
        mForecastAdapter = new ArrayAdapter<String>(
                            getContext(),
                            R.layout.list_item_forecast,
                            R.id.list_item_forecast_textview,
                            weekForecast);

        .....       
        }
    }