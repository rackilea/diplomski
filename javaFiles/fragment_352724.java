@GET
@Path("/getAllCourses")
@Produces("application/JSON")
public ArrayList<Course> getAllCourses(){
    return _handler.getAllCourses();

}