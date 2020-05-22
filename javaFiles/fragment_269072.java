public class Profile implements Comparable<Profile> { 
    DateTime date;
    double age; 
    int id; 

    ...

    @Override
    public int compareTo(Profile other) {
        return date.compareTo(other.getDate());  // compare by date
    }
}