public class TypesTask extends AsyncTask<String, Void, Void> {
    @Override
    protected void onPreExecute() {
        myRef = FirebaseDatabase.getInstance().getReference();
    }
    @Override
    protected Void doInBackground(String... params) {
        typeFinder(params[0]);
        return null;
    }
   @Override
   onPostExecute(Void result){
      String recipes = "";
      for (int i = 0; i < recipesList.size(); i++) {
                recipes = recipes + recipesList.get(i) + "\n";
      }
      testTextView.setText(recipes);
   }
}