public interface IRestClient {

  @GET("/apps/{id}/technologies")
  Observable<List<Technology>> getTechnologies(@Path("id") String id);

  //Remaining methods
}