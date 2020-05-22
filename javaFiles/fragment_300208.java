import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LanguageComboBoxExample extends Application {

    private static final Locale BLANK = new Locale("");

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Locale> langCombo = new ComboBox<>(FXCollections.observableArrayList(
                Locale.FRENCH,
                Locale.ENGLISH,
                Locale.GERMAN,
                BLANK               
        ));

        PseudoClass otherOptionPseudoClass = PseudoClass.getPseudoClass("other-option");

        langCombo.setCellFactory(lv -> new ListCell<Locale>() {
            @Override
            public void updateItem(Locale language, boolean empty) {
                super.updateItem(language, empty);
                if (empty) {
                    setText(null);
                    pseudoClassStateChanged(otherOptionPseudoClass, false);
                } else {
                    if (language == BLANK) {
                        setText("Other");
                        pseudoClassStateChanged(otherOptionPseudoClass, true);
                    } else {

                        // this gives the display you have:
                        setText(language.getLanguage());

                        // I prefer this for usability:
                        // setText(language.getDisplayLanguage(language));

                        pseudoClassStateChanged(otherOptionPseudoClass, false);
                    }
                }
            }
        });

        langCombo.setButtonCell(new ListCell<Locale>() {
            @Override
            public void updateItem(Locale language, boolean empty) {
                super.updateItem(language, empty);
                if (language == null || language == BLANK) {
                    setText(null);
                } else {
                    setText(language.getLanguage());
                }
            }
        });

        StackPane root = new StackPane(langCombo);
        Scene scene = new Scene(root, 175, 120);
        scene.getStylesheets().add("language-combo.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}