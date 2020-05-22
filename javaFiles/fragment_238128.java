private class JsonResponse extends AsyncTask<String, Void, String> {

    private ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();

    ...

    protected String doInBackground(final String... args)
    {
        ...

        // adding HashList to private JsonResponse's field
        resultList.add(hashServices);

        ...
    }

    protected void onPostExecute(String result) 
    {   
        if (response.equalsIgnoreCase("Success"))
        {
            ResultList_Services = resultList;
            //TODO: notify your Activity/Dialog on completion
        }
    }
}