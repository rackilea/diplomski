import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScrollTrackingTextArea extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        Label label = new Label();
        label.textProperty().bind(textArea.scrollTopProperty().asString("You are %.0f pixels from the top."));

        BorderPane root = new BorderPane(textArea, label, null, null, null);

        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Suspendisse ut odio eu est rutrum fermentum. Curabitur eu volutpat ante. "
                + "Pellentesque maximus laoreet dapibus. In vulputate vestibulum lectus, "
                + "non auctor purus suscipit at. Vivamus turpis magna, condimentum nec purus id, "
                + "iaculis ultrices nisl. Quisque eget mi vitae dolor placerat hendrerit et in nisi. "
                + "Nam eget velit sem. Suspendisse porta, tellus at ornare varius, "
                + "tellus massa tempor lacus, vel dictum nibh tortor sed turpis. "
                + "Curabitur commodo urna ac pharetra vulputate. Maecenas urna erat, "
                + "convallis in imperdiet ac, mollis nec risus. Nam eleifend aliquet "
                + "libero eu maximus. Nullam hendrerit, justo consectetur imperdiet porttitor, "
                + "libero tortor egestas neque, eget laoreet metus quam non erat. "
                + "Donec interdum dignissim dolor, et maximus arcu sodales quis. "
                + "Suspendisse commodo hendrerit odio a bibendum. Suspendisse sed dolor sed urna "
                + "congue porta at nec mauris. Suspendisse non risus a turpis aliquet suscipit. "
                + "Proin quis erat et nisl commodo venenatis. Nulla ipsum lorem, "
                + "blandit non posuere id, ultricies ac est. Pellentesque ut nunc laoreet, "
                + "finibus ligula porttitor, placerat massa. Sed quis nisl gravida metus venenatis "
                + "luctus ut quis sapien. Donec a nunc elit. Donec lobortis massa massa, "
                + "a scelerisque urna fringilla non. Donec molestie cursus nunc, "
                + "at convallis quam ultrices ut. Sed sed ornare nulla, eu dapibus purus. "
                + "Integer a tortor et odio rhoncus pretium. Nulla facilisi. Aliquam ut dapibus ligula. "
                + "Aenean auctor elementum neque, at congue lectus suscipit non. Suspendisse potenti. "
                + "Fusce vestibulum ex at nunc bibendum, in porttitor est lobortis. "
                + "Nam felis ex, vestibulum et dui nec, tristique semper enim. Maecenas libero erat, "
                + "tempor vitae nisi in, porttitor tincidunt nunc.Sed congue dui eu vulputate iaculis. "
                + "Quisque urna elit, aliquet molestie viverra ut, consectetur ut risus. "
                + "In ullamcorper nec nisl non posuere. Nullam ligula sem, malesuada a ornare in, "
                + "vestibulum eu purus. Cum sociis natoque penatibus et magnis dis parturient montes, "
                + "nascetur ridiculus mus. Ut molestie elit turpis, non blandit nunc consequat id. "
                + "Morbi vitae tincidunt ex. Maecenas justo odio, dapibus non iaculis a, tincidunt ut augue. "
                + "Praesent a sollicitudin neque. Curabitur in tempus nibh. Ut nec lacinia ante, ac tincidunt quam. "
                + "Phasellus porttitor tellus mi, et iaculis enim volutpat a. Nulla eget fringilla eros. "
                + "Phasellus ultricies aliquet massa. In quam leo, luctus a dolor sit amet, "
                + "facilisis consectetur enim. Vivamus ac odio et enim ultrices mattis. "
                + "Vivamus euismod nisi et posuere porttitor. Pellentesque vehicula libero id quam ultricies facilisis. "
                + "Vivamus vitae turpis vitae ligula efficitur aliquet eget eu risus. "
                + "Proin bibendum odio a lacus vulputate interdum. Nam luctus urna eu iaculis fringilla. "
                + "Quisque commodo metus risus. Quisque faucibus facilisis ultricies. "
                + "Vestibulum quis consequat nisi. Suspendisse finibus et tellus et eleifend. "
                + "Suspendisse congue malesuada urna, in eleifend arcu aliquam id. "
                + "Curabitur accumsan mi augue, ac laoreet neque viverra sit amet. Integer luctus tempus ligula non facilisis. "
                + "Maecenas eget lobortis felis.");

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}