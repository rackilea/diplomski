public class Dummy {
  public String value;
}

@GET
public Response get(@QueryParam("dummy") Dummy dummy) {}