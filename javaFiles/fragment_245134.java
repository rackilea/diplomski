@GET
@Path('/foos')
Response retrieveByKeys(@QueryParam('keys') Collection<String> keys, @QueryParam('startKey') String startKey, @QueryParam('pageSize') int pageSize) {
    List<FooRes> fooResources;
 //check if keys Collection is empty
 if(keys==null||keys.isEmpty()){
    if(startKey==null || startKey.isEmpty()){
      return Response.status(Status.BAD_REQUEST).build();
    }else{
       if(pageSize==null||pageSize.isEmpty()){
          //set default pageSize
          pageSize=10;

          //call your DAO or Repository or Service methods
        fooResources=foosRepo.partialResults(startKey,pageSize);
         ....

        }
   }else{
     fooResources=foosRepo.findByKeys(keys);
   }
 }

 return Response.ok().entity(fooResources).build();
}