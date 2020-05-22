private class ListAsync extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        Log.i("test", "Running on ui thread");
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.i("test", "Doding long operation on another thread");
        final XMLDOMParserHandler parser = new XMLDOMParserHandler(
                tag_name.toLowerCase(), this);
        if (isConnectivityOn(context)) {
            try {
                URL myURL = new URL("http://somewebsite.com/admin/data.xml");
                URLConnection ucon = myURL.openConnection();
                final InputStream is = ucon.getInputStream();
                nameAddressList = parser.parseXML(is);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            nameAddressList = parser.parseXML(getAssets().open("data.xml"));
        }
    }

    @Override
    protected void onPostExecute(Void result) {
        Log.i("tag", "getting back to uo thread to update user interface");
        ListOfPlacesAdapter listOfPlacesAdapter = new ListOfPlacesAdapter(
                this, nameAddressList);
        listView.setAdapter(listOfPlacesAdapter);
        listView.setItemsCanFocus(true);
    }

}