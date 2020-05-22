class CreateNewRequest extends AsyncTask<String, String, String> {
    protected String doInBackground(String... args) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat firstDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat secondDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

        String eDate = inputEdate.getText().toString();             

        try {
            Date date = firstDateFormat.parse(eDate);
            eDate = secondDateFormat.format(date);
            submitDate = secondDateFormat.format(c.getTime());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        List<NameValuePair> params = new ArrayList<NameValuePair>();            
        params.add(new BasicNameValuePair("submitDate", submitDate));
        params.add(new BasicNameValuePair("request_date", eDate));
    }
}