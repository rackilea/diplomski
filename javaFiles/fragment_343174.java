class OverlayLoader extends AsyncTask<Void, CustomizedItemOverlay, Void> {
    List<Overlay> mapOverlays;

    @Override
    protected onPreExecute() {
        mapOverlays = mapView.getOverlays();
    }

    @Override
    protected Void doInBackground(Void... params) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        startManagingCursor(mCursor);

        while (mCursor.moveToNext()) {

            Address = mCursor.getString(4);
            Name = mCursor.getString(0);

            String noSpaces = Address.replaceAll(" ", "+");

            JSONObject geocoded = getLocationInfo(noSpaces);
            GeoPoint point = getGeoPoint(geocoded);

            Drawable drawable = this.getResources().getDrawable(R.drawable.pushpin);
            CustomizedItemOverlay itemizedOverlay = 
                new CustomizedItemOverlay(drawable, this);

            CustomizedItemOverlay overlayitem = new OverlayItem(point, Name, Address);

            itemizedOverlay.addOverlay(overlayItem);
            publishProgress(overlayitem);
        }
    }

    @Override
    protected void onPublishProgress(CustomizedItemOverlay... overlayItem) {
        mapOverlays.add(itemizedOverlay);
    }
}