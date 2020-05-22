private class COntacts extends AsyncTask<Void, Void, List<ContactsHelper>> {

@Override
protected List<ContactsHelper> doInBackground(Void... urls) {
   List<ContactsHelper> contacts = new ArrayList<>();
   ...
   return contacts
}

@Override
protected void onPostExecute(List<ContactsHelper> result) {
    contacts.addAll(result);
    mAdapter.notifyDataSetChanged();
}