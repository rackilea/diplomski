@POST
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/{key}")
public 
@ResponseBody
Response getMessageFrom(@PathParam("key") String key, @RequestParam AOColumnSet aoColumnSet) throws NumberFormatException,  Exception{