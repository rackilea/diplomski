@PUT
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public String putTodo(JAXBElement<Route> r) {
    Route route = r.getValue();
    route.toString();
    System.out.println("Received PUT XML/JSON Request");
    return "ok";
}