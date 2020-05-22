public MyApp extends Application {
  private AdView mAdView;

   ...
   public void createAdView() {
     // this will refer to MyApp which is a context.
     mAdView = new AdView(this);

     ...
     // the rest is history
   }
}