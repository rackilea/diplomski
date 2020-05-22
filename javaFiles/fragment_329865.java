@Override
protected void onPostExecute(ArrayList<User> response) {

    // add all users to the adapter
    adapter=new LazyAdapter(ThesisProjectAndroid.this, mStrings, response);

    for(User user : response){

        System.out.println("User:- " +user.getFirstName());

        // ---- here be ur other code ----
    }
    listView.setAdapter(adapter);
}