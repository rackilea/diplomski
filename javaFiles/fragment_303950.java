import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextAreaScrollMonitor extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        DoubleProperty percentScrolled = new SimpleDoubleProperty();
        percentScrolled.bind(Bindings.createDoubleBinding(() -> {

            Node text = textArea.lookup(".content");
            Node scrollPane = textArea.lookup(".scroll-pane");

            if (text == null || scrollPane == null) {
                return 0.0 ;
            }

            double textHeight = text.getLayoutBounds().getHeight();
            double textAreaHeight = ((ScrollPane) scrollPane).getViewportBounds().getHeight();

            if (textHeight <= textAreaHeight) {
                return 100.0 ;
            }

            return 100.0 * textArea.getScrollTop() / (textHeight - textAreaHeight) ;

        }, textArea.scrollTopProperty()));

        Label label = new Label();
        label.textProperty().bind(percentScrolled.asString("Percent scrolled: %.1f"));

        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Curabitur ornare tellus et libero dignissim, consectetur sollicitudin ante vulputate. "
                + "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
                + "Integer rhoncus suscipit ligula eget maximus. Sed luctus viverra suscipit. Curabitur ac ligula "
                + "faucibus erat aliquet gravida sit amet a mauris. Cras vestibulum urna lacus, ac congue risus congue sed. "
                + "Duis massa enim, pharetra sit amet tellus vitae, consectetur ullamcorper nunc. "
                + "Integer lobortis porta lectus sed cursus. Suspendisse gravida felis tellus, "
                + "nec sagittis felis cursus eu. Proin dictum ac nisl in aliquet. "
                + "Etiam placerat consectetur placerat. Cras commodo mauris augue, nec tincidunt mauris posuere et. "
                + "Mauris rhoncus ex ac elit ullamcorper, tempor tincidunt odio volutpat.Nullam est odio, blandit in ex id, "
                + "pellentesque rutrum odio. Nullam aliquam sem turpis, eget auctor sapien fermentum sollicitudin. "
                + "Sed ullamcorper, nisi et fermentum tristique, sem urna fermentum massa, vitae tincidunt risus nisi et nisi. "
                + "Aliquam sagittis urna at elit tincidunt, eu lobortis leo vulputate. Vivamus id suscipit lorem. "
                + "Quisque sed nibh nec sem finibus suscipit aliquam eget felis. Suspendisse pulvinar venenatis augue, "
                + "at egestas nibh malesuada sit amet. Vivamus eget egestas velit. Nullam quis placerat elit. "
                + "Morbi aliquam velit nunc, a varius ipsum ultricies quis. Phasellus dui odio, viverra a sapien at, "
                + "auctor iaculis nunc.Praesent mauris nibh, dignissim vitae massa a, dapibus rutrum enim. "
                + "Aliquam aliquam tincidunt erat nec posuere. Ut elementum vel velit quis interdum. "
                + "Proin eget dapibus sapien. Cras faucibus urna nulla, sed volutpat ligula efficitur nec. "
                + "Aenean non ullamcorper nulla. Curabitur quis arcu sit amet nunc lacinia consectetur vitae nec elit. "
                + "In quis mollis dui. Morbi consectetur condimentum erat. Curabitur ut mollis dui. "
                + "Proin molestie gravida tempus.Nam consequat interdum odio at condimentum. Vestibulum augue tellus, "
                + "dignissim ac sem et, iaculis cursus massa. Donec facilisis nunc at erat malesuada, in luctus felis dictum. "
                + "Vivamus scelerisque accumsan tellus, eget gravida mauris. Etiam eu elit auctor nisl efficitur pretium. "
                + "Duis non eros arcu. Pellentesque tempus nibh et lorem ornare, at placerat sapien placerat. "
                + "Ut iaculis lectus at libero condimentum blandit. Vestibulum euismod dolor ut egestas laoreet. "
                + "Phasellus tempus at enim at posuere. Donec erat eros, mattis et justo fringilla, laoreet interdum tellus."
                + "In vehicula hendrerit nulla, sed ultrices neque rhoncus a. Proin vel volutpat lectus. "
                + "Sed egestas tellus ac consectetur elementum. Donec dolor ipsum, auctor eu turpis feugiat, "
                + "ullamcorper efficitur quam. Cras efficitur libero pulvinar magna tincidunt, eget faucibus libero suscipit. "
                + "Fusce elementum nulla vel magna porttitor elementum. Quisque accumsan euismod porttitor. "
                + "Sed nec sem non nisi aliquam consequat sit amet et metus. Curabitur facilisis enim non tristique tristique. "
                + "Morbi purus libero, molestie non purus ut, commodo semper dui. Quisque tellus nunc, porttitor ac egestas id, "
                + "venenatis vitae felis. Curabitur convallis dui lectus, eu sodales leo laoreet nec. Integer interdum pharetra dolor, "
                + "vitae sodales augue cursus sit amet.Aliquam ut turpis accumsan, lacinia felis eu, tristique eros. "
                + "Nullam laoreet eros tortor, et egestas augue sagittis nec. "
                + "Nam sit amet odio non eros maximus interdum sit amet et dolor. Nunc blandit tincidunt.");


        Scene scene = new Scene(new BorderPane(textArea, label, null, null, null));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}