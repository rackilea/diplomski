ParseObject hospitalAppointment = mStatus.get(position);//postition of that row

ParseObject doctor  = hospitalAppointment.getParseObject("columnName");
doctor.fetchIfNeededInBackground(new GetCallback<ParseObject>() {
    public void done(ParseObject doctor, ParseException e) {
        String docId= doctor.getObjectId();
      // Do something with your new title variable
    }
});