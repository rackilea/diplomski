import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** http://stackoverflow.com/questions/11765436/how-to-change-header-component-in-titledpane-in-javafx */
public class TitledPaneCustomization extends Application {
  public static void main(String[] args) { launch(args); }

  @Override public void start(Stage primaryStage) {
    TitledPane adminPane = new TitledPane("Administration", 
      VBoxBuilder.create().style("-fx-padding: 10").spacing(10).children(
        ButtonBuilder.create().text("Admin Client").maxWidth(Double.MAX_VALUE).build(),
        ButtonBuilder.create().text("Admin User").maxWidth(Double.MAX_VALUE).build()
      ).build()            
    );
    adminPane.setAnimated(false);
    adminPane.getStyleClass().add("admin");
    Node open   = HBoxBuilder.create().spacing(5).children(
      new Circle(4, 4, 8, Color.FORESTGREEN),
      new Rectangle(50, 16, Color.AQUAMARINE)
    ).build();
    Node closed = HBoxBuilder.create().spacing(5).children(
      new Circle(4, 4, 8, Color.GOLDENROD),
      new Rectangle(50, 16, Color.AQUAMARINE)
    ).build();

    adminPane.graphicProperty().bind(
      Bindings
        .when(adminPane.expandedProperty())
          .then(open)
          .otherwise(closed)
    );
    adminPane.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

    TitledPane viewPane = new TitledPane("View", 
      VBoxBuilder.create().style("-fx-padding: 10").spacing(10).children(
        ButtonBuilder.create().text("View Client").maxWidth(Double.MAX_VALUE).build(),
        ButtonBuilder.create().text("View User").maxWidth(Double.MAX_VALUE).build()
      ).build()            
    );
    viewPane.setAnimated(false);

    VBox errorPane = VBoxBuilder.create().style("-fx-padding: 10").spacing(10).children(
      new Label("500: Aug 8, 12:15pm"), 
      new Label("404: Aug 7, 3:27am")
    ).build();
    Label nErrors = new Label();
    nErrors.getStyleClass().add("nerrors");
    nErrors.textProperty().bind(Bindings.size(errorPane.getChildren()).asString());

    TitledPane connectivityPane = new TitledPane(
      "",      
      errorPane
    );
    Label connectivityErrorLabel = new Label("CONNECTIVITY ERROR");
    connectivityErrorLabel.getStyleClass().add("connectivityErrorLabel");
    connectivityPane.getStyleClass().add("connectivity");
    connectivityPane.setAnimated(false);
    connectivityPane.setGraphic(
      HBoxBuilder.create().spacing(2).alignment(Pos.CENTER).styleClass("header").children(
        nErrors,    
        new ImageView(
          new Image(
            "http://openiconlibrary.sourceforge.net/gallery2/open_icon_library-full/icons/png/48x48/actions/network-disconnect-2.png",
            0, 24, true, true
          )
        ),
        connectivityErrorLabel
      ).build()
    );

    HBox layout = new HBox(10);
    layout.setStyle("-fx-padding: 10; -fx-background-color: cornsilk;");
    layout.getChildren().addAll(adminPane, viewPane, connectivityPane);
    layout.setPrefHeight(150);
    layout.getStylesheets().add(this.getClass().getResource("titledpanecustomization.css").toExternalForm());
    primaryStage.setScene(new Scene(layout));
    primaryStage.show();

    Node arrow = adminPane.lookup(".arrow");
    arrow.setVisible(false);
    arrow.setManaged(false);

    // translate the titledpane arrow and header so that the arrow is displayed to right of the header.
    Pane connectivityArrow = (Pane) connectivityPane.lookup(".arrow");
    connectivityArrow.translateXProperty().bind(
      connectivityPane.widthProperty().subtract(connectivityArrow.widthProperty().multiply(2))
    );
    Pane connectivityTitle = (Pane) connectivityPane.lookup(".header");
    connectivityTitle.translateXProperty().bind(
      connectivityArrow.widthProperty().negate()
    );
  }
}