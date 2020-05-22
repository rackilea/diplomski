import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramandeep Singh on 17-03-2016.
 */
public class Reviews {
    @SerializedName("reviews")
    @Expose
private MovieReview reviews;

    public Reviews() {
    }


    public MovieReview getReviews() {
        return reviews;
    }

    public void setReviews(MovieReview reviews) {
        this.reviews = reviews;
    }
}