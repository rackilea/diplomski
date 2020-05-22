public class QueryCardsAsyncTask extends AsyncTask<Void, Void, ArrayList<String>> {

    private ArrayList<String> queriedCardIDList = new ArrayList<>();

    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        if (shouldIQuery()) {
            // You logic to be written in async task
        } else {
            // else part, get your data from preference

            myPreferences.loadCardsPrefs();
            for (CardModel c : myPreferences.getSavedCards()) {
                queriedCardIDList.add(c.getCardID());
            }
        }

        return queriedCardIDList;
    }

    @Override
    protected void onPostExecute(ArrayList<String> cardIdList) {
        super.onPostExecute(cardIdList);
        // Now use cardIdList here as per your requirement
    }
}