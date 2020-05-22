import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

public class LibraryExample extends Application {

    // Our list of shelves that will be displayed in the ListView
    private final ObservableList<Shelf> shelves = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Build a list of 100 sample books. This list could come from a database or other outside source, of course
        List<Book> books = FXCollections.observableArrayList();
        for (int i = 0; i < 100; i++) {
            books.add(new Book("Book #" + i, new ImageView("sample/generic-cover.png")));
        }

        // We will now create our shelves for the books. We will limit the number of books to 6 per shelf. This uses
        // the subList method of our List to grab every 6 books until we run out.
        int index = 0;
        while (index < books.size()) {

            // Make sure there are at least 6 books remaining, otherwise, we need to get the subList up to the size of
            // the original list.
            final int numToAdd = (index + 6 <= books.size() ? index + 6 : books.size());
            shelves.addAll(new Shelf(books.subList(index, numToAdd)));
            index += 6;
        }

        // Now, let's create our ListView that will hold our shelves.
        ListView<Shelf> listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        // Now for the magic. We will override the CellFactory for the ListView so we can provide our own layout
        // for each row
        listView.setCellFactory(new Callback<ListView<Shelf>, ListCell<Shelf>>() {
            @Override
            public ListCell<Shelf> call(ListView<Shelf> param) {
                return new ShelfListCell();
            }
        });

        listView.setItems(shelves);

        root.getChildren().add(listView);

        // Show the Stage
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

class ShelfListCell extends ListCell<Shelf> {

    @Override
    protected void updateItem(Shelf shelf, boolean empty) {
        super.updateItem(shelf, empty);

        if (shelf == null || empty) {
            setGraphic(null);
        } else {

            // Here, we will build our layout for each shelf
            VBox root = new VBox(5);
            root.setAlignment(Pos.CENTER);
            root.setPadding(new Insets(5));

            HBox hBox = new HBox(20);
            hBox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(5));

            // Add image for each each book on this shelf to the layout
            for (Book book : shelf.getBooks()) {

                // Get the image of the book and add a simple click listener
                ImageView cover = book.getCoverImage();
                cover.setPreserveRatio(true);
                cover.setFitHeight(100);
                cover.setOnMouseClicked(event -> System.out.println("Clicked " + book.getTitle()));

                hBox.getChildren().add(book.getCoverImage());
            }

            root.getChildren().addAll(hBox, new Separator(Orientation.HORIZONTAL));

            // Set the cell to display our layout
            setGraphic(root);

        }
    }
}