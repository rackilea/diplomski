public class GetBannerDB extends AsyncTask<Void, Void, ArrayList<String>> {
   public OnDataListner dataListner;

  GetBannerDB(OnDataListner dataListner) { 
      this.dataListner = dataListner;
  }

   @Override
  protected void onPostExecute(ArrayList<String> result) {
    super.onPostExecute(result);
    dataListner.setData(result);

  }
}