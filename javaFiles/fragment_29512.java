public void onClick(View v) {
        if(v == searchBtn)
        {
            String input = searchInput.getText().toString();
            if(input != null && input.length() != 0)
            {

                try {
                    new TestTask().execute(input);

                } catch(Exception ex) {
                    ex.printStackTrace();
                } 
            }
        }
    }

private void startSearch(PlaceList places) {
  Bundle bundle = new Bundle();
  bundle.putParcelable("places", places);
  Intent i = new Intent(this, SearchResultsActivity.class);
  i.putExtras(bundle);

  startActivity(i);
}

private class TestTask extends AsyncTask<String, Void, PlacesList>
{
...

        @Override
        protected void onPostExecute(PlacesList results)
        {
           startSearch(results);
           if(dlg.isShowing())
                dlg.dismiss();
        }

}