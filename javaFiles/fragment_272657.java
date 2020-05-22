public class MovieShowings{

    private AnchorPane root;

    public MovieShowings() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("movieshowings.fxml"));
            root = loader.load();
            MovieShowingsController controller = loader.getController();
            controller.initMovieShowings(this);
        }

        catch(IOException e){

            e.printStackTrace();
        }

    }
    ...

}