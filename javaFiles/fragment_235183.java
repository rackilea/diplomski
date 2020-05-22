// Get the data item for this position
WeatherData weather = getItem(position);
// Check if an exising view is being reused, otherwise inflate the view
if (convertView == null){
    convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_array_layout, parent, false);
}
// CHANGED HERE the textView "weather` had the same name of the "WeatherData" defined a few lines above
// Lookup view for data population
TextView textDate = (TextView) convertView.findViewById(R.id.date);
TextView textWeather = (TextView) convertView.findViewById(R.id.weather);

// CHANGED HERE to properly call the textView methods and to read the fields from the instance of "WeatherData"
// Populate the data into the template view using the data object
textDate.setText(weather.date);
textWeather.setText(weather.weather);

// Return the completed view to render on screen
return convertView;