clockIn.saveInBackground(new SaveCallback() {
    @Override
    public void done(ParseException e) {
        clockInId = clockIn.getObjectId();  //Save objectID that was just created
        Log.d(TAG, "objId:" + clockInId);
    }