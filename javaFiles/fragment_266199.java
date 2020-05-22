@GET
@Path("find")
@Produces(MediaType.APPLICATION_XML)
public FindResponse find(@QueryParam("paramBean") ParameterBean paramBean) {
    String prop1 = paramBean.getProp1();
    String prop2 = paramBean.getProp2();
    String prop3 = paramBean.getProp3();
    String prop4 = paramBean.getProp4();
}