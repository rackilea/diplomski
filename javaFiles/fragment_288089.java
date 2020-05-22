@POST
@Path("/update/{collection}")
public Response update(@PathParam("collection") String collection, @Context UriInfo info, InputStream inputStream) 
{
     String fullPath = info.getAbsolutePath().toASCIIString();
     System.out.println("full request path: " + fullPath);

     // query params are also available from a map.  query params can be repeated,
     // so the Map values are actually Lists.  getFirst is a convenience method
     // to get the value of the first occurrence of a given query param
     String foo = info.getQueryParameters().getFirst("bar");

     // do the rewrite...
     String newURL = SomeOtherClass.rewrite(fullPath);

     // the InputStream will have the body of the request.  use your favorite
     // HTTP client to make the request to Solr.
     String solrResponse = SomeHttpLibrary.post(newURL, inputStream);

     // send the response back to the client
     return Response.ok(solrResponse).build();