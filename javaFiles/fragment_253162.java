@POST
@Consumes({  MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public Response post(Student s,@HeaderParam("Accept") String accept){
    if(accept!=null && accept.contains(MediaType.APPLICATION_XML)){
    accept = MediaType.APPLICATION_XML;
    }else{
    accept = MediaType.APPLICATION_JSON;
    }
    //Construct list
    Response.ok(list, accept).build();
}