@GET
@Path("/foo")
public String myMethod(@DefaultValue("foo") @QueryParam("valString") String valString,
                       @DefaultValue("1") @QueryParam("valInt") int valInt,
                       @DefaultValue("true") @QueryParam("valBool") boolean valBool) {
    ....
}