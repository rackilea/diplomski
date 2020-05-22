public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    EditText cityName;
    String city = null;

    ListView dayListView;
    ArrayList<WeatherData> weatherDataArrayList;

    DayAdapter dayAdapter;
    //private String responseJSON = null;
    //WeatherAdapter weatherAdapter = null; // Creating this adapter within the DayAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.cityName);
        Button load = (Button) findViewById(R.id.loadButton);

        dayListView = (ListView) findViewById(R.id.dayList);

        load.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                city = cityName.getText().toString();
                Log.d(TAG, "onClick: city is : " + city);
                if (city == null)
                {
                    Toast toast = null;
                    toast.makeText(MainActivity.this,"Please Enter a city before continuing",Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + (city.toLowerCase()) + "&units=metric&appid=8b10912e19fde267f36f6cb785ee7efd";

                    Log.d(TAG, "onCreate: staring download task");
                    DownloadJSON downloadJSON = new DownloadJSON();
                    downloadJSON.execute(url);
                    Log.d(TAG, "onCreate: after downloadtask");
                }
            }
        });
    }

    public void SetDayListData(ArrayList<String> dayBlock, ArrayList<WeatherData> weatherBlock)
    {
        if (dayAdapter == null)
        {
            dayAdapter = new DayAdapter(MainActivity.this,R.layout.layout_day_card, days, weatherDataArrayList);
            dayListView.setAdapter(dayAdapter);
        }
        else
        {
            //created a new method "UpdateData" just to update the data in the adapter
            dayAdapter.UpdateData(days, weatherDataArrayList);
            dayAdapter.notifyDataSetChanged();
        }
    }

    private class DownloadJSON extends AsyncTask<String, Void, String>
    {
        private static final String TAG = "DownloadJSON";

        private String downloadJSON(String url)
        {
            StringBuilder jsonResult = new StringBuilder();

            try
            {
                URL apiURL = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
                int responseCode = connection.getResponseCode();
                Log.d(TAG, "downloadJSON: Response code "+ responseCode);
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                int charReader;
                char[] inputBuffer = new char[500];
                while (true)
                {
                    charReader = reader.read(inputBuffer);
                    if (charReader < 0)
                    {
                        break;
                    }
                    if (charReader > 0)
                    {
                        jsonResult.append(String.copyValueOf(inputBuffer, 0, charReader));
                    }
                }
                reader.close();
                return jsonResult.toString();
            }
            catch (MalformedURLException e)
            {
                Log.e(TAG, "downloadJSON: URL is Invalid");
            }
            catch (IOException e)
            {
                Log.e(TAG, "downloadJSON: IO Error");
            }
            return null;
        }

        @Override
        protected String doInBackground(String... strings)
        {
            Log.d(TAG, "doInBackground: url is : " + strings[0]);
            String jsonResponse = downloadJSON(strings[0]);
            if (jsonResponse == null)
            {
                Log.e(TAG, "doInBackground: Error downloading");
            }
            return jsonResponse;
        }

        @Override
        protected void onPostExecute(String jsonResponse)
        {
            super.onPostExecute(jsonResponse);

            Log.d(TAG, "onPostExecute: json received is : " + jsonResponse);
            if (jsonResponse != null)
            {
                JsonToWeatherData jtwd = new JsonToWeatherData();
                weatherDataArrayList = jtwd.extractor(jsonResponse);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                String date1 = simpleDateFormat.format(calendar.getTime());
                calendar.add(Calendar.DATE,1);
                String date2 = simpleDateFormat.format(calendar.getTime());
                calendar.add(Calendar.DATE,1);
                String date3 = simpleDateFormat.format(calendar.getTime());
                calendar.add(Calendar.DATE,1);
                String date4 = simpleDateFormat.format(calendar.getTime());
                calendar.add(Calendar.DATE,1);
                String date5 = simpleDateFormat.format(calendar.getTime());
                ArrayList<String> days = new ArrayList<>();
                days.add(date1);
                days.add(date2);
                days.add(date3);
                days.add(date4);
                days.add(date5);

                SetDayListData(days, weatherDataArrayList);
            }
            else
            {
                Log.d(TAG, "onPostExecute: no json recieved, city is Wrong");
                Toast toast = Toast.makeText(MainActivity.this,"Please provide a valid city!",Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}

public class DayAdapter extends ArrayAdapter<String>
{
    private static final String TAG = "DayAdapter";

    private Context context;

    private LayoutInflater layoutInflater;
    private int layoutresourceID;

    private ArrayList<String> dayBlock;
    private ArrayList<WeatherData> dayWeather, weatherBlock;

    JsonToWeatherData json = new JsonToWeatherData();

    public DayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> dayBlock, ArrayList<WeatherData> weatherBlock)
    {
        super(context, resource, dayBlock);
        this.context = context;
        this.dayBlock = dayBlock;
        this.weatherBlock = weatherBlock;
        layoutInflater = LayoutInflater.from(context);
        this.layoutresourceID = resource;

        if (weatherBlock == null)
        {
            Log.e(TAG, "DayAdapter: full block is null");
        }
    }

    @Override
    public int getCount()
    {
        return dayBlock.getSize();
    }

    public void UpdateData(@NonNull ArrayList<String> dayBlock, ArrayList<WeatherData> weatherBlock)
    {
        this.dayBlock = dayBlock;
        this.weatherBlock = weatherBlock;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(layoutresourceID,parent,false);
        }

        if (weatherBlock == null)
        {
            Log.d(TAG, "getView: weatherBlock is null");
            return convertView;
        }

        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView minTempFoDay = (TextView) convertView.findViewById(R.id.minTempOfDay);
        TextView maxTempFoDay = (TextView) convertView.findViewById(R.id.maxTempOfDay);
        ListView weatherHolderListView = (ListView) convertView.findViewById(R.id.wHoldLV);

        String dateString = dayBlock.get(position);
        dayWeather = json.extractByDate(weatherBlock, dateString);

        if (dayWeather == null)
        {
            Log.d(TAG, "getView: dayweather array is null");
            return convertView;
        }

        if (position > dayWeather.getSize() - 1)
        {
            Log.d(TAG, "getView: the position is too great for the dayWeather array");
            return convertView;
        }

        String test = dayWeather.get(position).getTemp(); // error occured here
        Log.d(TAG, "getView: test string : " + test);

        date.setText(dateString);

        DecimalFormat df = new DecimalFormat(".##");
        float mint = 500, maxt = 0;
        String mint1 = "", maxt1 = "";

        for (WeatherData data : dayWeather)
        {
            if (mint > Float.parseFloat(data.getMinTemp()))
            {
                mint = Float.parseFloat(data.getMinTemp());
                mint1 = df.format(mint);
                Log.d(TAG, "getView: mint : " + mint);
            }

            if (maxt > Float.parseFloat(data.getMaxTemp()))
            {
                maxt = Float.parseFloat(data.getMaxTemp());
                maxt1 = df.format(maxt);
            }
        }

        minTempFoDay.setText(mint1);
        maxTempFoDay.setText(maxt1);

        WeatherAdapter weatherAdapter = new WeatherAdapter(context, R.layout.weather_holder, dayWeather);
        weatherHolderListView.setAdapter(weatherAdapter);

        return convertView;
    }
}