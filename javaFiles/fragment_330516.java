String name = human.getName();

    return Response
      .status(Response.Status.OK)
      .entity(name)
      .build();