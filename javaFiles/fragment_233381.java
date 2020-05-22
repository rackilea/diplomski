@GET
public Object getView(@Context HttpServletRequest req)
{
     if (somethingBad())
     {
         URI uri = UriBuilder.fromUri("/somewhere_else").build();
         return Response.seeOther(uri).build();
     }

     return new View();
}