@GET
 @Path("/images/{image}")
 @Produces("image/*")
 public Response getImage(@PathParam("image") String image) {
     File f = new File(image);

     if (!f.exists()) {
         throw new WebApplicationException(404);
     }

     String mt = new MimetypesFileTypeMap().getContentType(f);
     return Response.ok(f, mt).build();
 }