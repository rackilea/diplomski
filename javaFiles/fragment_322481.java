private class AsyncTaskSaveDelete extends AsyncTask<Void, Void, boolean> {
    private DBHandler handler;
    private Recipe recipe;
    private boolean isDelete;

    public AsyncTaskSaveDelete(DBHandler handler,Recipe recipe,boolean isDelete ){
        this.handler = handler;
        this.recipe = recipe;
        this.isDelete = isDelete;
    }

     protected Long doInBackground( {
         if(isDelete){
            return dbHandler.deleteRecipe(recipe);
         }else{
          return dbHandler.addRecipe(recipe);
         }
     }

     protected void onPostExecute(boolean result) {
         runOnUiThread(new PostRunnable(){
            //update the UI
         })
     }
 }


public void newRecipe (View view){
...
    new AsyncTaskSaveDelete(handler,recipe,false).execute();
...
}