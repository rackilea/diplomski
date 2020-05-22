@GET @Path(IMAGE_ID_PATH_PARAM)
    @Produces("image/*")
    public Response getImage(@PathParam("imageId") String imageId,
        @PathParam("extension") String extension, @QueryParam("mods") String mods) {
        ...
    }

    @PUT @Path(IMAGE_ID_PATH_PARAM)
    @Consumes("image/*")
    public Response putImage(@PathParam("imageId") String imageId, File image) {
        ...
    }