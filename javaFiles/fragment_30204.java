public class LoadJSONTask extends AsyncTask<String, Void, List<Company>> {

    ...

    @Override
    protected List<Company> doInBackground(String... strings) {
        ...
        List<Company> companies = new Gson().fromJson(stringResponse, new TypeToken<ArrayList<Company>>(){}.getType());
        return companies;
        ...
    }

    @Override
    protected void onPostExecute(List<Company> companies) {
        if (companies != null) {
            mListener.onLoaded(companies);
        } else {
            mListener.onError();
        }
    }
}