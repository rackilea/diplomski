public static class WeatherAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final SparseArray<WeatherCondition> weatherConditions;

    public WeatherAdapter(LayoutInflater inflater, SparseArray<WeatherCondition> weatherConditions) {
        this.inflater = inflater;
        this.weatherConditions = weatherConditions;
    }

    @Override
    public int getCount() {
        return weatherConditions.size();
    }

    @Override
    public WeatherCondition getItem(int position) {
        return weatherConditions.valueAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.weather_list_item, parent);
        }
        WeatherCondition weatherCondition = getItem(position);
        //TODO configure the views in weather_list_item using data in weatherCondition
        return convertView;
    }
}