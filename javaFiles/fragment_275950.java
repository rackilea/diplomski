import java.util.Scanner;
import java.util.concurrent.FutureTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyJavaProgram {
    public static void main(String[] args) throws Exception {

        // start FX toolkit on background thread:
        new Thread(() -> Application.launch(FXStarter.class)).start();
        // wait for toolkit to start:
        FXStarter.awaitFXToolkit();

        // make sure closing first window does not exit FX toolkit:
        Platform.setImplicitExit(false);

        int input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0 - exit");
            System.out.println("1 - display something to me");
            input = scanner.nextInt();
            switch (input) {
                case 0:
                    break;
                case 1:
                    // task to show UI:
                    FutureTask<Void> showProgramTask = new FutureTask<>(() -> {
                        MyJavaFXProgram program = new MyJavaFXProgram();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(program.getView(), 400, 400));
                        stage.setOnShown(e -> {
                            stage.toFront();
                            stage.requestFocus();
                        });
                        // showAndWait will block execution until window is hidden:
                        stage.showAndWait();
                        return null ;
                    });
                    // show UI on FX Application Thread:
                    Platform.runLater(showProgramTask);
                    // block until task completes (i.e. window is hidden):
                    showProgramTask.get() ;
                    break;

            }
            if (input == 0) break;
        }

        // all done, exit FX toolkit:
        Platform.exit();
        scanner.close();
    }

}