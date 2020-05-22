public Pollen(int zipcode, final Context context) {
    this.context = context;
    this.zipcode = zipcode;
    Document doc;

    try {
       // pass address to Wunderground's website using our inputted zipcode
       doc = Jsoup.connect("http://www.wunderground.com/DisplayPollen.asp?Zipcode=" + this.zipcode).get();

       if(doc.select("div.columns").first().text() == null) {
           // Oh no! div.colums is empty. Lets throw an exception, which
           // will prevent the code below from executing.
           throw new IllegalStateException("div.columns is NULL");
       }

       // get "location" from XML
       Element location = doc.select("div.columns").first();
       this.location = location.text();

       // get "pollen type" from XML
       Element pollenType = doc.select("div.panel h3").first();
       this.pollenType = pollenType.text();

       SimpleDateFormat format = new SimpleDateFormat("EEE MMMM dd, yyyy");

       // add the four items of pollen and dates
       // to its respective list
       for(int i = 0; i < 4; i++) {
           Element dates = doc.select("td.text-center.even-four").get(i);
           Element levels = doc.select("td.levels").get(i);

           // Removed nested try-catch block
           pollenMap.put(format.parse(dates.text()), levels.text());
       }
    } catch (IOException e) {
        displayToast(context);
    } catch (ParseException e) {
        // We catch the ParseException here instead of nesting try-catch blocks.
        displayToast(context);
    } catch (IllegalStateException e) {
        // Catch the IllegalStateException thrown when div.columns was null,
        // and let the user know what went wrong.
        displayToast(context);
    }
}

private void displayToast(Context context) {
    ((Activity) context).runOnUiThread(new Runnable() {
        public void run() {
            Toast toast = Toast.makeText(context, R.string.toast_parse_fail, Toast.LENGTH_LONG);
            toast.show();
        }
    });
}