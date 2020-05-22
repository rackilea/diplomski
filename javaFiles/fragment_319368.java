@Override
  public int getViewType(int position) {
    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("NativeAd");
    query.whereEqualTo("objectId", "fYBeufqdOt");
    final int[] n =  new int[1];
    query.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject object, ParseException e) {
            n[0] = Integer.valueOf(String.valueOf(object));
        }
    });

    int viewType = VIEW_TYPE_MARKET_FEED;
    if ((position % n[0] == 0) && position > 0) {
        viewType = VIEW_TYPE_AD;
    }
    return viewType;
}