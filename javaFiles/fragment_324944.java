public interface APIService {
    @GET("roles") /*removed the / here */
    Call<Modal> getDetails();
}

private static final String ENDPOINT = "http://badiyajobs.com/apis/v1/"; /* added the / here */