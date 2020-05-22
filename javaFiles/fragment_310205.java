@Override
public void onCreate(Bundle savedInstanceState) {
    mMapView.setOnSingleTapListener(new OnSingleTapListener() {
        public void onSingleTap(float x, float y) {
            Point point = mMapView.toMapPoint(x, y);
                Log.e("Coord", point.toString());
                new MyAsyncTask().execute(point);
            }
    });
}

private class MyAsyncTask extends AsyncTask<Point, Integer, Double> {
    @Override
    protected Double doInBackground(Point... params) {
        if(params.length == 1) {
            try {
                eventCtrl.createEvent(params[0].toString());
                eventCtrl.retrieveEventJSON();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void onPostExecute(Double result) {
    }

    protected void onProgressUpdate(Integer... progress) {
    }
}