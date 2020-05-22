@Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater earthquake = LayoutInflater.from(getContext());
//        View customView = convertView;
        if(convertView == null){
            convertView = earthquake.inflate(R.layout.custom_layout,parent,false);

        }
        earthquake currentEarthquakeAdapter = getItem(position);
        TextView Magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        Magnitude.setText(currentEarthquakeAdapter.get_magnitude());
        TextView Location = (TextView) convertView.findViewById(R.id.location);
        Location.setText(currentEarthquakeAdapter.get_location());

        return convertView;
    }