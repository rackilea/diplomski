@GET
@Path("elements2")
public Response getElements2(@HeaderParam(SESSION_TOKEN) String token) {
      try {
          if (token == null) {
              return ResponseFactory.createResponse(401, 4007);
          }
          Session session = new Session();
          if (session.initWithToken(token)) {
              ElementFacade sf = ElementFacade.getInstance();
              List<Element> list = sf.getElements(session.getUser());
              return Response.status(200)
                      .header(Endpoint.SESSION_TOKEN, session.getToken())
                      .entity(new GenericEntity<List<Element>>(list) {}).build();
          }
          return ResponseFactory.createResponse(403, 4006);
      } catch (InvalidTokenException e) {
          return ResponseFactory.createResponse(401, 4005);
      } catch (SessionTimeoutException e) {
          return ResponseFactory.createResponse(401, 4004);
      } catch (Throwable th) {
          log.error("", th);
          return ResponseFactory.createResponse(500, 5099);
      }
}