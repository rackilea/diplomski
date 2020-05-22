public class Movie {
    private String title, director;
    private float overallRating;
    private ShowingStatus showingStatus;

    public enum ShowingStatus {ComingSoon, Preview, NowShowing}

    public Movie(String title, ShowingStatus showingStatus, String director)
    {
        this.title = title;
        this.showingStatus = showingStatus;
        this.director = director;
        overallRating = 0;
    }
}