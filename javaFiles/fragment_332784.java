final IRequestMapper o=getRootRequestMapper();

setRootRequestMapper(new IRequestMapper() {
   [...] 
   @Override
   public Url mapHandler(IRequestHandler r) {
       Url u=o.mapHandler(r);
       if (condition)
          u.setProtocol("https");
       return u;
   }
});