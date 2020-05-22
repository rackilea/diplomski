RestAdapter ra = new RestAdapter.Builder()
        .setServer("http://api.stackexchange.com/2.1")
        .build();
ISites sites = ra.create(ISites.class);
ra.getAllSites("", new Callback<CommonSEWrapper<Site>>(){
   @Override
   public void failure(RetrofitError argRetrofitError){
   }
   @Override
   public void success(CommonSEWrapper<Site> sites, Response response){
       // sites is filled in, just like magic!
   }
});