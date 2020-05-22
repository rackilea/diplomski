@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/1.0/people") //no need for .json suffix as API only return JSON format
public List<String> allLocations(..){ //jackson etc. will convert return type to json string 
..
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/1.0/people/{personId: \\d+}")//digits only
public String getLocation(..){ //jackson etc. will convert return type to json string 
..
}