public class itemsByInput_AsyncTask extends AsyncTask<Void, itemRoot_api_constr, Void> {

 JSONObject Jo_result;
 private itemListToListings itemListToListings;
 String userSearchRequest;

 public itemsByInput_AsyncTask(String userSearchRequest){
  this.userSearchRequest = userSearchRequest;
 } 

 private String makeUrl(int page){
    return "http://www.gw2spidy.com/api/v0.9/json/item-search/" + 
           this.userSearchRequest + "/" + page;
 }

 @Override
 protected Void doInBackground(Void... params) {
    itemRoot_api_constr iac;

    iac = JoToJO_constructor(spidyHttpGetRequest(makeUrl(0)));
    nPage = iac.getLast_page();
    publishProgress(iac);

    for (int n = 1; n<nPage; n++){
         publishProgress(spidyHttpGetRequest(makeUrl(n)));
    }
    return null;
 }

 @Override
 protected void onProgressUpdate(itemRoot_api_constr... iacs) {
       super.onProgressUpdate(iacs);
       // assuming method itemListToListings updates UI
       // if it doesn't then publishProgress and onProgressUpdate are not needed 
       // and itemListToListings can be done in doInBackground
       this.itemListToListings.itemListToListings(iacs[0]);
 }

  @Override
  protected Void onPostExecute(Void void) {
    super.onPostExecute(void);   
    // unused    
 }
}