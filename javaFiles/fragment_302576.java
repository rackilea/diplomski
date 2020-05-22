import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class FXMLDocumentController implements Initializable {

  @FXML
  private TreeView treeView;

  private final List<JobProgress> jobList = Arrays.<JobProgress>asList(
          new JobProgress("JJ&P_POP_DAT", "Running Jobs"),
          new JobProgress("Des_master_33334", "Running Jobs"),
          new JobProgress("FS_BUSS", "Running Jobs"),
          new JobProgress("CONER_DWN_MIX", "Running Jobs"),
          new JobProgress("newjb", "Running Jobs"),
          new JobProgress("jb name", "Running Jobs"),
          new JobProgress("tst jb", "Pending Jobs"),
          new JobProgress("ult--ob", "Pending Jobs"),
          new JobProgress("inl jb", "Pending Jobs"),
          new JobProgress("fst jb", "Completed Jobs"),
          new JobProgress("VoCt_Nme_Jb", "Completed Jobs"));

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    TreeItem<String> rootNode = new TreeItem<>("Job Details");

    rootNode.setExpanded(true);

    for (JobProgress jb : jobList) {
      Text text = new Text();
      ProgressBar bar = new ProgressBar(0.0);
      bar.progressProperty().bind(jb.jobProgressProperty());

      text.setBoundsType(TextBoundsType.VISUAL);
      text.setFill(Color.BLACK);
      text.textProperty().bind(jb.jobProgressStringProperty());

      StackPane stack = new StackPane();
      stack.getChildren().addAll(bar, text);
      Node icon = stack;

      TreeItem<String> empLeaf = new TreeItem<>(jb.getJobName(), icon);
      boolean found = false;
      for (TreeItem<String> depNode : rootNode.getChildren()) {
        if (depNode.getValue().contentEquals(jb.getJobStatus())) {
          depNode.getChildren().add(empLeaf);
          found = true;
          break;
        }
      }
      if (!found) {
        TreeItem<String> depNode = new TreeItem<>(jb.getJobStatus());
        rootNode.getChildren().add(depNode);
        depNode.getChildren().add(empLeaf);
      }
    }
    treeView.setRoot(rootNode);
    new Thread(simulateProgress()).start();

  }

  private Task<Void> simulateProgress() {
    Task<Void> task = new Task<Void>() {

      @Override
      protected Void call() throws Exception {
        for (double i = 0.0; i <= 1.0; i += 0.1) {
          for (JobProgress job : jobList) {
            job.setJobProgress(i);
          }
          Thread.sleep(1000);
        }
        return null;
      }
    };
    return task;
  }
}