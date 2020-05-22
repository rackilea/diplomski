// do the http requests you have in the queryWebService method and when it's time to update the data:
runOnUiThread(new Runnable() {
        @Override
    public void run() {
        autoCompleteAdapter.clear();
        // add the data
                for (int i = 0; i < length; i++) {
                     // do json stuff and add the data
                     autoCompleteAdapter.add(theNewItem);                    
                } 
                // trigger a filter on the AutoCompleteTextView to show the popup with the results 
                autoCompleteAdapter.getFilter().filter(s, autoComplete);
    }
});