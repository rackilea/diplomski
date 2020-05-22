import java.util.Objects;
import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    TextArea area = new TextArea();
    area.setPrefRowCount(5);
    area.setPrefColumnCount(25);
    area.setTextFormatter(new TextFormatter<>(new ExpectedTextFilter("Hello, World!")));

    StackPane root = new StackPane(area);
    root.setPadding(new Insets(10));

    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  private static class ExpectedTextFilter implements UnaryOperator<Change> {

    private final String expectedText;

    ExpectedTextFilter(String expectedText) {
      this.expectedText = Objects.requireNonNull(expectedText);
    }

    @Override
    public Change apply(Change change) {
      if (change.isContentChange()) {
        if (change.isReplaced()) {
          // simply don't allow replacements
          return null;
        } else if (change.isDeleted()) {
          // only allow deletions from the end of the control's text
          return change.getRangeEnd() == change.getControlText().length() ? change : null;
        } else {
          return expectedText.startsWith(change.getText(), change.getRangeStart()) ? change : null;
        }
      }
      return change;
    }
  }
}