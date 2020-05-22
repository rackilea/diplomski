public class GetUserRest extends ServerResource{
    @Get @Delete
    public String getUser() throws ResourceException {
      if(getMethod().getName().equals("DELETE")) {
            return "delete method";
        } else if(getMethod().getName().equals("GET")) {
            return "get method";
        }
    }

}