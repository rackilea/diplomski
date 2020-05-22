@GET
@Produces("application/javascript")
public String getVersion(@QueryParam("callback") String callback) {
      return callback + "(\"hello\")";
// NOTE ------------------^^-----^^
}