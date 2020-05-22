@POST
  @Path("/schedule")
  public String tigerMessage(
      @FormParam("postvar[]") List<String> vars) throws Exception
  {
    System.out.println(vars)
    return ""
  }