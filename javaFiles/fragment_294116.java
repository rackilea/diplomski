@GET
  @Produces("application/json")
  @Consumes("application/json")
  @Path("/status")
  // server:8080/server/rest/status
  public String getStatus(
      @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws Exception
  {

    // Create a string to hold JSON
    String json;

      Collection<Server> svr = SomeHashMap.getStuff().values();

      JSONArray jArray = new JSONArray();

      for (Server i : svr)
      {
        JSONObject m = new JSONObject();

        ServerStatus status = i.getStatus();

        m.put("id", i.getId());
        m.put("name", i.getName());
        m.put("status", status.getState());

        jArray.add(m);
      }

      json = jArray.toString();
    }

    response.setContentType("text/javascript");
    response.getOutputStream().print(json);
    response.flushBuffer();

    return null;
}