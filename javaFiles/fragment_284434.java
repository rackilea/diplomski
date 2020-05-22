package countdown;

import countdown.cli.CLICountdownApp;
import countdown.gui.JavaFXCountdownApp;
import javafx.application.Application;

public class Countdown {

    public static void main(String[] args) {
        if (args.length == 1 && "cli".equalsIgnoreCase(args[0])) {
            new CLICountdownApp().runApp();
        } else {
            Application.launch(JavaFXCountdownApp.class);
        }
    }

}