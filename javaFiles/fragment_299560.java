public class All_user{
    double [] All_users;

    public All_user(Rating...argument) {
        ArrayList<Double> ratings = new ArrayList<Double>();
        for (Rating r : argument) {
            for (double d : r.Ratings) ratings.add(d);
        }
        All_users = new double[ratings.size()];
        for (int i=0; i<ratings.size(); i++) All_users[i] = ratings.get(i);
    }
}