import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.w3c.dom.Document;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebEngine;

public class WebEngineProblem {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new JFXPanel(); // Initialise the JavaFx Platform

        CountDownLatch loaded = new CountDownLatch(1);

        FutureTask<WebEngine> createEngineTask = new FutureTask<WebEngine>( () -> {
            WebEngine webEngine = new WebEngine();
            final Worker<Void> loadWorker = webEngine.getLoadWorker();
            loadWorker.stateProperty().addListener((obs, oldValue, newValue) -> {
                System.out.println("state:" + newValue);
                if (newValue == State.SUCCEEDED) {
                    System.out.println("finished loading");
                    loaded.countDown();
                }    
            });
            webEngine.loadContent("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
                + "<title>Content Title</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "<p>Body</p>\r\n" + "</body>\r\n"
                + "</html>\r\n");
            return webEngine ;
        });

        Platform.runLater(createEngineTask);
        WebEngine engine = createEngineTask.get();
        loaded.await();

        Platform.runLater(() -> {
            Document doc = engine.getDocument();
            String content = doc.getDocumentElement().getTextContent();
            System.out.println(content);
        });
    }

}