private DBQuery dBQ = new DBQuery();
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getresponses(String si) {
      return this.dBQ.getItems(si).toString();
  }