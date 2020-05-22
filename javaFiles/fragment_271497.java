import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class StyledLabel extends Application {

    public static final Font ITALIC_FONT =
            Font.font(
                    "Serif",
                    FontPosture.ITALIC,
                    Font.getDefault().getSize()
            );

    @Override
    public void start(final Stage stage) throws Exception {
        Text lastNameText = new Text("Einstein");
        Text firstNameText = new Text("Albert");
        Text yearText = new Text("1905");
        Text titleOfArticleText = new Text("Zur Elektrodynamik bewegter Körper");
        Text titleOfJournalText = new Text("Annalen der Physik");
        titleOfJournalText.setFont(ITALIC_FONT);
        Text volumeText = new Text("17");
        Text pageNumbersText = new Text("891-921");
        Text doiText = new Text("10.1002/andp.19053221004");

        Label reference = new Label(
                null,
                new TextFlow(
                        lastNameText, new Text(", "),
                        firstNameText, new Text(". ("),
                        yearText, new Text("). "),
                        titleOfArticleText, new Text(". "),
                        titleOfJournalText, new Text(", "),
                        volumeText, new Text(", "),
                        pageNumbersText, new Text(". "),
                        doiText
                )
        );

        stage.setScene(new Scene(reference));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}