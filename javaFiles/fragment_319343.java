public class StopsInfoWindow implements GoogleMap.InfoWindowAdapter {

    private HashMap<Marker, JSONObject> stopsMarkersInfo;
    private View view;

    public StopsInfoWindow(HashMap<Marker, JSONObject> stopsMarkersInfo) {
         this.stopsMarkersInfo = stopsMarkersInfo;
    }

    @Override
    public View getInfoContents(Marker marker) {
         return null;
    }

    @Override
    public View getInfoWindow(final Marker marker) {
        JSONObject stop = stopsMarkersInfo.get(marker);
        if (stop != null) {
            LayoutInflater inflater = (LayoutInflater) Controller.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_stop_marker_info, null);

            TextView stopName = (TextView) view.findViewById(R.id.stop_name);
            stopName.setText(stop.getString("name"));

            TextView stopLine = (TextView) view.findViewById(R.id.stop_line);
            stopLine.setText(stop.getString("line"));
        }
        return view;
    } 
}