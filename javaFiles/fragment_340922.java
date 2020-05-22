ArrayList<String> adDetails = new ArrayList<>();

   mBannerTask  = new GetBannerDB(new OnDataListner{

     @Overrid
    public void setData(ArrayList<String> result){

         adDetails   = result;
         //do something

        }

  });
 mBannerTask.execute();