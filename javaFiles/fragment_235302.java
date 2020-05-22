parseQuery.findInBackground(new FindCallback<ParseObject>() {
    @Override
    public void done(List<ParseObject> objects, ParseException e) {
        if (e == null) 
         {
            for (ParseObject object : objects) {
                drinksSize.add(object.getInt("size"));
                drinksName.add(object.getString("itemName"));
                dates.add(getDate(object.getCreatedAt()));
            }
         getPieData();
         getBarData();
        }else{
            Log.i(TAG, "exception: " + e.getMessage());
        }
    }
});