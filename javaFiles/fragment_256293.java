import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.stream.IntStream;

public class GridViewer extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        ChartGrid grid = new ChartGrid();

        grid.getChildren().setAll(
                IntStream.range(1, 5)
                        .mapToObj(this::createLineChart)
                        .toArray(Chart[]::new)
        );

        stage.setScene(new Scene(grid));
        stage.show();
    }

    class ChartGrid extends GridPane {
        ChartGrid() {
            setHgap(5);
            setVgap(5);
            setPadding(new Insets(5));

            setPrefSize(500, 500);

            Bindings.size(getChildren()).addListener((observable, oldSize, newSize) -> {
                ObservableList<Node> nodes = getChildren();
                for (int i = 0; i < newSize.intValue(); i++) {
                    GridPane.setConstraints(
                            nodes.get(i),
                            i / 2, i % 2,
                            1, 1,
                            HPos.CENTER, VPos.CENTER,
                            Priority.ALWAYS, Priority.ALWAYS
                    );
                }
            });
        }
    }

    private Chart createLineChart(int idx) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Chart " + idx);
        chart.setMinSize(0, 0);

        return chart;
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}