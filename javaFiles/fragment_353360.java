interface IService {

    @GET("/")
    @ByRegExp("member_.+")
    Call<List<Member>> getMembers();

}