public class Rating{
    double [] Ratings;
    int CustomerID;
    int Domain;

    public Rating (int id, int d, double...x) {
        double [] Ratings = x;
        int CustomerID=id;
        int Domain=d;
    }
}