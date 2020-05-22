@Path("/root")
public class ServiceDelegator{

    @GET
    @Path("/getDetailsAsXML")
    @Produces(MediaType.APPLICATION_XML)
    public Todo getDetailsAsXML() {
        return new GetDetailsService().getDetails();
    }


    @GET
    @Path("/getDetailAsJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getDetailsAsJSON() {
        return new GetDetailsService().getDetails();
    }

}



public class GetDetailsService{    // your service class containing the business methods

    public Todo getDetails() {    // Todo is just a pojo return type which would finally be converted into either XML or JSON type based on the delegator method that invoked this service
        Todo todo = new Todo();
        todo.setSummary("This is my first todo");
        todo.setDescription("This is my first todo");
        return todo;
    }

}



public class Todo {  

    private String summary;
    private String description;

    // Getters and Setters

}