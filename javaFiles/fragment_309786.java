import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ramandeep Singh on 17-03-2016.
 */
public class MovieService {
    public interface MovieDbApi {

        @GET("/3/movie/{id}?&append_to_response=reviews")
        Call<Reviews> getReviews(
                @Path("id") int id,
                @Query("api_key") String apiKey);

    }
}