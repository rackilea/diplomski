import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MessageClientGui extends Application {
    private static final String CLIENT_ID = "George";

    private static MessageService msgService;

    private TextField message;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label prompt = new Label("Message");
        message = new TextField();
        Button send = new Button("_Send");
        send.setOnAction(this::sendMessage);
        send.setTooltip(new Tooltip("Sends message to [RMI] server."));
        HBox root = new HBox(5.0D, prompt, message, send);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sendMessage(ActionEvent actnEvnt) {
        try {
            msgService.newMessage(CLIENT_ID, message.getText());
        }
        catch (RemoteException x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            msgService = (MessageService) registry.lookup("MessageService");
            launch(args);
        }
        catch (Exception x) {
            x.printStackTrace();
        }
    }
}