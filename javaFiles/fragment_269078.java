import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class Merge extends Application {
    private static final int N_VALUES = 13;
    private static final int SPACING = 60;
    private static final int SORT_GROUP_MOVE_DELTA = 200;

    private static final Duration SPEED = Duration.millis(400);

    private int[] helper;
    private StackPane[] helperNodes;
    private Random random = new Random(5);

    @Override
    public void start(Stage stage) throws Exception {
        Pane displayPane = new Pane();
        ArrayList<StackPane> list = new ArrayList<>();
        for (int i = 0; i < N_VALUES; i++) {
            StackPane stackPane = createValueNode(i);
            list.add(stackPane);
        }

        displayPane.getChildren().addAll(list);

        Button sortButton = new Button("Sort");
        sortButton.setOnAction(event -> {
            SequentialTransition sq = new SequentialTransition();
            int[] arr = generateArray(list);
            sq = mergeSort(arr, list, sq);
            sortButton.setDisable(true);
            sq.play();
            sq.setOnFinished(event1 -> sortButton.setDisable(false));
            sortButton.setDisable(false);
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(displayPane);
        borderPane.setBottom(sortButton);
        BorderPane.setAlignment(sortButton, Pos.CENTER);
        BorderPane.setMargin(sortButton, new Insets(10));

        Scene scene = new Scene(borderPane, 800, 400);
        stage.setTitle("Sorting");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private StackPane createValueNode(int i) {
        int num = random.nextInt(10);
        Rectangle rectangle = new Rectangle(40, (num * 10) + 50);
        rectangle.setFill(Color.valueOf("#FF7F50"));
        Text text = new Text(String.valueOf(num));
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(rectangle.getWidth(), rectangle.getHeight());
        stackPane.setId(String.valueOf(num));
        stackPane.getChildren().addAll(rectangle, text);
        StackPane.setAlignment(text, Pos.TOP_CENTER);
        stackPane.setAlignment(Pos.TOP_CENTER);
        stackPane.setTranslateX(SPACING * i);
        return stackPane;
    }


    private int[] generateArray(List<StackPane> list) {
        int arr[] = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(list.get(i).getId());
        }
        return arr;
    }

    private TranslateTransition move(StackPane sp, int X) {
        TranslateTransition t = new TranslateTransition();
        t.setNode(sp);
        t.setDuration(SPEED);
        t.setToX(X);
        t.setToY(SORT_GROUP_MOVE_DELTA);
        return t;

    }

    public SequentialTransition mergeSort(int arr[], ArrayList<StackPane> list, SequentialTransition sq) {
        int number = arr.length;
        this.helper = new int[number];
        this.helperNodes = new StackPane[number];
        sortRange(0, number - 1, arr, sq, list);
        return sq;
    }

    private void sortRange(int low, int high, int arr[], SequentialTransition sq, ArrayList<StackPane> list) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            sortRange(low, middle, arr, sq, list);
            // Sort the right side of the array
            sortRange(middle + 1, high, arr, sq, list);
            // Combine them both
            merge(low, middle, high, arr, list, sq);
        }
    }


    private void merge(int low, int middle, int high, int arr[], ArrayList<StackPane> list, SequentialTransition sq) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
            helperNodes[i] = list.get(i);
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                arr[k] = helper[i];
                list.set(k, helperNodes[i]);
                sq.getChildren().add(move(helperNodes[i], k * SPACING));
                i++;
            } else {
                arr[k] = helper[j];
                list.set(k, helperNodes[j]);
                sq.getChildren().add(move(helperNodes[j], k * SPACING));
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            arr[k] = helper[i];
            list.set(k, helperNodes[i]);
            sq.getChildren().add(move(helperNodes[i], k * SPACING));
            k++;
            i++;
        }

        // Even if we didn't move in the array because it was already ordered, 
        // move on screen for any remaining nodes in the target array.
        while (j <= high) {
            sq.getChildren().add(move(helperNodes[j], k * SPACING));
            k++;
            j++;
        }

        ParallelTransition moveUp = new ParallelTransition();

        for (int z = low; z <= high; z++) {
            TranslateTransition moveNodeUp = new TranslateTransition();
            moveNodeUp.setNode(helperNodes[z]);
            moveNodeUp.setDuration(SPEED);
            moveNodeUp.setByY(-SORT_GROUP_MOVE_DELTA);
            moveUp.getChildren().add(moveNodeUp);
        }

        sq.getChildren().add(moveUp);
    }

    public static void main(String[] args) {
        launch(args);
    }
}