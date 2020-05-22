class ModelClass {

   @Inject
   Provider<HTTPRequest> httpRequestProvider;

   public void populate() {
      HTTPRequest request = httpRequestProvider.get();
   }

}