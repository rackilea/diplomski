public class RatedMessage {
    private final String message;
    private final int rating;

    public RatedMessage(String message, int rating) {
        this.message = message;
        this.rating = rating;
    }

    public String toString() {
        return rating + ": " + message;
    }

    public static int compareRating(RatedMessage rm1, RatedMessage rm2) {
        return rm1.rating - rm2.rating;
    }
}