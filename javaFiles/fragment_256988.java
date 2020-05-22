String mTitle = Helper.readString("Enter movie title > ");
String tName = Helper.readString("Enter theatre name > ");

// Create `Movie` and `Theatre` instance
// Ideally you would not create a new instance. Rather just fetch them from 
// database, or some `static` list, in case of in-memory implementation.
// From your implementation, it seems like the entered value might not be the exact
// match. So that you have to handle.
Movie movie = new Movie(mTitle);
Theatre theatre = new Theatre(tName);

// If you are fetching the movie and theatre from some database or list, then 
// you should just check if `movie` and `theatre` is not `null`
if (movies.contains(movie) && theatres.contains(theatre) {
    int year = Helper.readInt("Enter year > ");
            int month = Helper.readInt("Enter month > ");
            int day = Helper.readInt("Enter day > ");
            int hour = Helper.readInt("Enter hour > ");
            int min = Helper.readInt("Enter min > ");

            screenings.add(new MovieScreening(Helper.thisDate(year,
                    month, day, hour, min), movies.get(i), theatres
                    .get(j), 0));
            System.out.println("Added successfully");
} else {
    System.out.println("Your movie or/and theatre cannot be found.");
}