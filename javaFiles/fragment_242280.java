ParseObject scripts = new ParseObject("Script");
scripts.put("Scripts to say", "**Enter Script Here**");
scripts.put("Cheatmode", false);
scripts.saveInBackground(); // or scripts.saveEventually(); depending whether you want to use the object immediately or not, don't use both.


ParseQuery<ParseObject> query = ParseQuery.getQuery("Script");
query.whereEqualTo("Scripts to say", "**Enter Script Here**");
query.getFirstInBackground(new GetCallback<ParseObject>() {
    public void done(ParseObject script, ParseException e) {
        if (script != null) {
            Log.d("Object retrieved.");
            String yourString = script.getString("Scripts_to_say");
            //NOW ADD IT TO YOUR EDITTEXT HERE           
        } else {
            Log.d("Empty query");
        }
    }
});