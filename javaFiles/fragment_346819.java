Future<Address> myFutureResult = deferredGeocode(ec, address).flatMap(
  new Mapper<Address, Future<Address>>() {
    public Future<Address> apply(Address geocodedAddress) {
      return deferredWriteToSearchEngine(ec, addressSearchService, geocodedAddress);
   }
  }, ec).map(
     new Mapper<Address, SomeResult>() {
       public SomeResult apply(Address savedAddress) {
         // Create SomeResult after deferredWriteToSearchEngine is done
       }
    }, ec);