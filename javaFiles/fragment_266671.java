public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder>{

    private List<WeatherData> weatherDataList;

    public TextView locationTextView;
    public TextView tempTextView;
    public TextView humidTextView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Here we are inflating the CardView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_weather_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherData weatherData = this.weatherDataList.get(position);
        CardView cardView = holder.cardView;

        // We then add these items to each CardView
        locationTextView = (TextView) cardView.findViewById(R.id.locationTextView);
        tempTextView = (TextView) cardView.findViewById(R.id.tempTextView);
        humidTextView= (TextView) cardView.findViewById(R.id.humidText);

        locationTextView.setText(weatherData.getName());
        tempTextView.setText("Temperature: "+weatherData.getWeatherDetails().getTemperature());
        humidTextView.setText("Humidity: "+ weatherData.getWeatherDetails().getHumidity());
    }

    @Override
    public int getItemCount() {
        return this.weatherDataList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;

        public ViewHolder(View v){
            super(v);
            // Each ViewHolder only has a CardView (even though that CardView has child TextViews
            cardView = (CardView) v;
        }

    }

    public WeatherListAdapter(List<WeatherData> weatherDataList){
        this.weatherDataList = weatherDataList;
    }
}