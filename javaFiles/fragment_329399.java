RpcProxy<PagingLoadConfig, PagingLoadResult<Post>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<Post>>() {
   @Override
   public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<Post>> callback) {
      service.getPostsBySearchCriteria(loadConfig, searchCriteria, callback); // make sure your rpc service receive search criteria parameter
   }
};