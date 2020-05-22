public interface PokeApi {

   // If you need to get the response body + headers ...
    @GET("pokemon")
    Observable<Response<RemoteDataObjectModel>> getPokemonList2(@Query("limit") int limit, @Query("offset") int offset);


   // If you only need body
    @GET("pokemon")
    Observable<RemoteDataObjectModel> getPokemonList2(@Query("limit") int limit, @Query("offset") int offset);

   // Or the better way, the result from API is only return once. So, Single is more suitable in this case
    @GET("pokemon")
    Single<RemoteDataObjectModel> getPokemonList2(@Query("limit") int limit, @Query("offset") int offset);

}