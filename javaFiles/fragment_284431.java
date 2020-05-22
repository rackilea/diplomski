package countdown.cli;

import java.util.Scanner;

import countdown.CountdownTimer;

public class CLICountdownApp {

    public void runApp() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter time for timer:");
        int time = scanner.nextInt() ;
        scanner.close();
        CountdownTimer timer = new CountdownTimer(time);
        timer.setSecondsRemainingChangedHandler(t -> System.out.println(t +" seconds remaining"));
        timer.setOnFinishedHandler(() -> System.out.println("Timer finished!"));
        timer.start();
    }
}