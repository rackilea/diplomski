@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response storeData(Data data) {
  ..
  int status = samePosition(..);
  return Response.status(status).build();
}

private int samePosition(..) {
  int status = 201;
  if() {
    ...
    if (distanceRange.size() == 0) {
      processData(macD, routeD, latD, longD);
    } else {
      status = <Preferred HTTP status code to return for not processing>;
    }
  } else {

  }
  return status;
}