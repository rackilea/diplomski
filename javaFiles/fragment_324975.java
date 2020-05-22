public Response represent(){
try{

}catch(Exception ex){
    return Response.status(500)
            .entity(new ExceptionMessage("500", ex.getMessage()))
            .type(MediaType.APPLICATION_JSON).
            build();
}
return Response.status(Response.Status.OK).entity(result).build();