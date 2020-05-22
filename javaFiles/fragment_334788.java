import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WebReader extends Application{
    // Class variable to hold our found URLs :)
    static ArrayList<String> listArray;

    public static void main(String[] args) throws IOException {
        // Gather page & URL data, and read it
        String address = "http://reddit.com";
        URL pageLocation = new URL(address);
        Scanner in = new Scanner(pageLocation.openStream());
        // Initialize an ArrayList to store all of our collected URLs
        listArray = new ArrayList<String>();
        // Decipher the code line by line
        while (in.hasNext()) {
            String line = in.next();
            if (line.contains("href=\"http://")) {
                int from = line.indexOf("\"");
                int to = line.lastIndexOf("\"");
                System.out.println(line.substring(from + 1, to));
                listArray.add(line.substring(from + 1, to));
            }
        }

        // Next, we implement into JavaFx
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My loaded photos");
        // Create a place to put our content
        HBox content = new HBox();
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToHeight(true);
        System.out.println(listArray.size());
        for (int i = 0; i <= listArray.size() - 1; i++) {
            Image img = new Image(listArray.get(i));
            ImageView imgView = new ImageView(img);

            content.getChildren().add(imgView);
        } // Launch and sail away!! :)

        Scene s = new Scene(scrollPane, 800, 600);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}