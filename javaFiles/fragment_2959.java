@POST
@Consumes({
  MediaType.APPLICATION_JSON
})
@Produces({
  MediaType.APPLICATION_JSON
})
@Path("JsonPostExample")
public String JsonPostExample(@PathParam("studentId") String studentId, List < Students > studentS) {
  System.out.println(studentS.toString());
  // Do whatever you want to do with the object
  return studentId;

}