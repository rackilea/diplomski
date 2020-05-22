package com.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {

  private final Executor executor = Executors.newSingleThreadExecutor(r -> {
    Thread t = new Thread(r, "controller-thread");
    t.setDaemon(true);
    return t;
  });

  @FXML private ListView<String> listView;

  @FXML
  private void handleOpenFile(ActionEvent event) {
    event.consume();

    FileChooser chooser = new FileChooser();
    chooser.getExtensionFilters()
        .add(new ExtensionFilter("Text Files", "*.txt", "*.json", "*.xml", "*.html", "*.java"));

    File file = chooser.showOpenDialog(listView.getScene().getWindow());
    if (file != null) {
      ReadFileTask task = new ReadFileTask(file.toPath());
      task.setOnSucceeded(wse -> listView.setItems(FXCollections.observableList(task.getValue())));
      task.setOnFailed(wse -> task.getException().printStackTrace());
      executor.execute(task);
    }
  }

  private static class ReadFileTask extends Task<List<String>> {

    private final Path file;

    private ReadFileTask(Path file) {
      this.file = Objects.requireNonNull(file);
    }

    @Override
    protected List<String> call() throws Exception {
      return Files.readAllLines(file);
    }

  }

}