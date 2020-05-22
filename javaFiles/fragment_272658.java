public class MovieShowingsController {

    ...

    public void initMovieShowings(MovieShowings showings) {
        String date = "2019-04-15";
        Date sqlDate = Date.valueOf(date);

         System.out.println("\n");
         System.out.println("***Screenings for " + date + "***");

         filmList = new ArrayList();
         screeningList = DatabaseConnection.getInstance().retrieveScreeningsForDay(sqlDate);

         for (Screening screeningInstance : screeningList) {

             if (!filmList.contains(screeningInstance.getFilmInfo())) {

                 filmList.add(screeningInstance.getFilmInfo());

             }

             System.out.println(screeningInstance.toString());
          }

        Collections.sort(screeningList);

        this.showings = showings;

        //populating FXML instance variable from loader

        // use the injected field here
        buildMovieShowings(vbox);
    }

    ...
}