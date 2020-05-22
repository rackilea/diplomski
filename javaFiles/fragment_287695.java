package org.jewelsea;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SearchField extends StackPane {
    private final TextField textField;
    private final Button searchButton;
    private final Label searchResults;

    public SearchField() {
        textField = new TextField();
        textField.setPromptText(
                "Search Text"
        );

        searchButton = new Button("Search");

        searchResults = new Label();

        VBox layout = new VBox(
                20,
                new HBox(
                        10,
                        textField,
                        searchButton
                ),
                searchResults
        );
        layout.setPadding(new Insets(10));

        searchButton.setOnAction(event ->
                searchResults.setText(
                        "Search result for " + textField.getText()
                )
        );

        getChildren().setAll(
                layout
        );
    }
}