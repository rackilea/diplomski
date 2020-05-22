new AsyncTask<Void, Void, Results>() {
    @Override
    protected Results doInBackground(Void... params) {
        String result = OpenALPR.Factory.create(MainActivity.this, ANDROID_DATA_DIR).recognizeWithCountryRegionNConfig("us", "", destination.getAbsolutePath(), openAlprConfFile, 10);

        Log.d("OPEN ALPR", result);

       Results results = new Gson().fromJson(result, Results.class);
        if (results != null || results.getResults() != null || results.getResults().size() > 0)
            Log.d("ShowTheResults", results.getResults().get(0).getPlate());

        return results;
    }

    @Override
    protected void onPostExecute(Results result) {
        if (results == null || results.getResults() == null || results.getResults().size() == 0) {
            Toast.makeText(MainActivity.this, "It was not possible to detect the licence plate.", Toast.LENGTH_LONG).show();
            resultTextView.setText("It was not possible to detect the licence plate.");
        } else {
            resultTextView.setText("Plate: " + results.getResults().get(0).getPlate()
                    // Trim confidence to two decimal places
                    + " Confidence: " + String.format("%.2f", results.getResults().get(0).getConfidence()) + "%"
                    // Convert processing time to seconds and trim to two decimal places
                    + " Processing time: " + String.format("%.2f", ((results.getProcessingTimeMs() / 1000.0) % 60)) + " seconds");
        }
    }
}.execute();