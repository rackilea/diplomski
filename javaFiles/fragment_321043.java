@GET
public Response get() {
    return Response.ok("blah").cookie(new NewCookie("foo", "bar")).build();
}

[..]

Client client = ClientBuilder.newClient();
Response response = client.target(url).request().cookie(new Cookie("foo", "bar")).get();