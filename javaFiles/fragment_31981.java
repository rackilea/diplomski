@POST
@Produces( MediaType.TEXT_PLAIN )
@Consumes( "application/xml" )
public Response validate(Contents con){ //con will be initialized by JAX-RS
  //validate your XML converted to object con
  boolean validation_ok = ...
  if(validation_ok){
     return Response.ok("true").build();
  }else{
     return Response.ok("false").build();
  }
}