@PUT @Path("{id}") 
 @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }) 
 public Wine update(@PathParam("id") String id,Wine wine) {
     return dao.update(wine); 
 }