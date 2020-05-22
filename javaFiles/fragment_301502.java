class AirLineListRetriever extends AsyncTask<Void, Void, List<Airline>> {

    private String FSAPIid = "appId=xxxxx";

    private Context mContext;

    public interface AirLineListResponse{
        void processFinish(List<Airline> airlines);
    }

    AirLineListResponse delegate;

    public AirLineListRetriever(AirLineListResponse delegate, Context context){
        this.delegate = delegate;
        this.mContext = context;
    }


    @Override
    protected List<Airline> doInBackground(Void... params) {

        JSONObject JSONAirlines;
        JSONObject JSONAirline;
        JSONArray JSONAirlinesList;
        Airline airline;
        List<Airline> airlineList;

        try {

            Log.d("ALPrint", "In Retrieve Airline List");

            URL url = new URL("https://api.flightstats.com/flex/airlines/rest/v1/json/active?" + FSAPIid);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();



                FileHelper.saveToFile(stringBuilder.toString(), mContext);

                JSONAirlines = new JSONObject(stringBuilder.toString());
                JSONAirlinesList = JSONAirlines.getJSONArray("airlines");
                airlineList = new ArrayList<Airline>();

                for (int i = 0; i < JSONAirlinesList.length(); i++) {
                    JSONAirline = JSONAirlinesList.getJSONObject(i);
                    String airlineName = JSONAirline.has("name") ? JSONAirline.getString("name") : null;
                    String fsCode = JSONAirline.has("fs") ? JSONAirline.getString("fs") : null;
                    String iataCode = JSONAirline.has("iata") ? JSONAirline.getString("iata") : null;
                    String icaoCode = JSONAirline.has("icao") ? JSONAirline.getString("icao") : null;

                    airline = new Airline(
                            airlineName,
                            fsCode,
                            iataCode,
                            icaoCode
                    );
                    airlineList.add(airline);

                }

                return airlineList;
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(List<Airline> airlineList){
        this.delegate.processFinish(airlineList);
    }


}