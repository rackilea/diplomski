@Path("/person")
public PersonRestService {

    // Maybe injected using @Autowired if you are using spring
    private SomeController someController;

    @Get
    @Path("{id}")
    public void getPerson(PathParam("id") String id){
       try {
           Long personId = Long.valueOf(id);

           someController.someMethod(new ControllerParams(){
                public Long getPersonId(){
                    return personId;
                }
           });
       } catch (NumberFormatException e) {
           // handle it
       }
    }
}