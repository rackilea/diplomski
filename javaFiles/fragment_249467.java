@POST
  @Path("/schedule")
  public String tigerMessage(
      Form form) throws Exception
  {
    System.out.println(form);
    // Then get parameters from form
    return ""
  }