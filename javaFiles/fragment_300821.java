@Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        String activity_title = getResources().getString(R.string.housing_button);
        Intent intent = new Intent(this, DisplayDataActivity.class);
        Bundle extras = new Bundle();
        extras.putString("title", activity_title);
        extras.putString("JSON_Object", result);
        intent.putExtras(extras);
        startActivity(intent);
    }



public void btnType0(View view) {
    new JSONTask().execute("URL_with_API");
}