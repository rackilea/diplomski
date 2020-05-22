import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class WebViewVideo extends Application {
  public static void main(String[] args) { Application.launch(args); }
  @Override public void start(Stage primaryStage) {
    WebView root = new WebView();
    root.getEngine().loadContent(
      "<video width='320' height='240'controls='controls'>" +
        "<source src='http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv'/>" + 
        "Your browser does not support the video tag." + 
      "</video>");
    primaryStage.setScene(new Scene(root, 340, 260));
    primaryStage.show();
  }
}