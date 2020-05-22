import javafx.application.Application;

import javafx.animation.TranslateTransition;

import javafx.geometry.Insets;
import javafx.geometry.Side;

import javafx.util.Duration;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.layout.Region;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class PlaylistDemo
extends Application {
    private static final Duration ANIMATION_SPEED = Duration.seconds(0.5);

    private enum ExpandState { EXPANDED, HIDDEN, CHANGING }

    private ExpandState expandState = ExpandState.HIDDEN;

    @Override
    public void start(Stage stage) {
        TableView<Object> musicList = new TableView<>();
        musicList.getColumns().add(new TableColumn<Object, Object>("Name"));
        musicList.getColumns().add(new TableColumn<Object, Object>("Artist"));
        musicList.getColumns().add(new TableColumn<Object, Object>("Album"));

        Region playlist = new BorderPane(musicList);
        playlist.setMaxWidth(Region.USE_PREF_SIZE);
        playlist.setStyle("-fx-background-color: white;");

        Label tabLabel = new Label("PlayList");
        Tab playlistTab = new Tab(null, playlist);
        playlistTab.setGraphic(tabLabel);
        playlistTab.setClosable(false);

        TabPane tabPane = new TabPane(playlistTab);
        tabPane.setSide(Side.LEFT);
        tabPane.setRotateGraphic(true);

        // Placeholder, to reserve space for playlist tab.
        TabPane dummyTabPane = new TabPane(new Tab("Dummy", new Label()));
        dummyTabPane.setSide(Side.LEFT);
        dummyTabPane.setVisible(false);

        Label player = new Label("Music player goes here");
        player.setPadding(new Insets(200));

        BorderPane musicPane =
            new BorderPane(player, null, dummyTabPane, null, null);
        BorderPane.setMargin(player, new Insets(0, 24, 0, 0));

        StackPane applicationPane = new StackPane(musicPane, tabPane);

        playlist.layoutBoundsProperty().addListener((o, old, b) -> {
            double tabWidth = playlist.localToScene(b).getMinX() -
                tabPane.localToScene(0, 0).getX();
            tabPane.setTranslateX(applicationPane.getWidth() - tabWidth);
        });
        applicationPane.widthProperty().addListener((o, old, width) -> {
            double tabWidth =
                playlist.localToScene(playlist.getLayoutBounds()).getMinX() -
                tabPane.localToScene(0, 0).getX();
            tabPane.setTranslateX(applicationPane.getWidth() - tabWidth);
        });

        tabLabel.setOnMouseEntered(e -> {
            if (expandState == ExpandState.HIDDEN) {
                TranslateTransition transition =
                    new TranslateTransition(ANIMATION_SPEED, tabPane);
                transition.setByX(-playlist.getWidth());

                expandState = ExpandState.CHANGING;
                transition.setOnFinished(ae -> {
                    expandState = ExpandState.EXPANDED;
                });

                transition.play();
            }
        });

        playlist.setOnMouseExited(e -> {
            if (expandState == ExpandState.EXPANDED) {
                TranslateTransition transition =
                    new TranslateTransition(ANIMATION_SPEED, tabPane);
                transition.setByX(playlist.getWidth());

                expandState = ExpandState.CHANGING;
                transition.setOnFinished(ae -> {
                    expandState = ExpandState.HIDDEN;
                });

                transition.play();
            }
        });

        stage.setScene(new Scene(applicationPane));
        stage.setTitle("Player");
        stage.show();
    }

    public static class Main {
        public static void main(String[] args) {
            Application.launch(PlaylistDemo.class, args);
        }
    }
}