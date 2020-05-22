public static void UpdateCallSign(String newCallSign, final Context cntx) {

    ParseUser user = ParseUser.getCurrentUser();
    user.put("CallSign", newCallSign);
    user.saveInBackground(new SaveCallback() {
        public void done(ParseException e) {
            if (e == null) { <--------- This is what I changed
                // Saved successfully
                Toast.makeText(cntx, "Call Sign Updated",
                        Toast.LENGTH_LONG).show();
                Log.d("Success", "Success");
            } else {
                // ParseException
                Log.d("Exception: ", e.getMessage());
            }
        }
    });

}