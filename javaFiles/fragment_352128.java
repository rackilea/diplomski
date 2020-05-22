import java.util.Scanner;

public class Test {
    static final Scanner sc = new Scanner(System.in);

    private void answerYes(String video) {
        System.out.println("Please enter a date you would like to show the video:");
        String date = sc.nextLine();
        System.out.println("Please enter a time you would like to show the video:");
        String time = sc.nextLine();

        // Do something with this
        System.out.println(String.format("You have chosen date: %s and time: %s", date, time));
    }

    private void showOptions(String[] videos, String noMoreVideosMsg) {
        int currentVideoIdx = 0;
        while (currentVideoIdx < videos.length) {
            System.out.println(String.format("Option %d: %s", currentVideoIdx + 1, videos[currentVideoIdx]));
            System.out.println("Would you like to use this video? (yes / no)");
            String answer = sc.nextLine();
            if (answer.equals("yes")) {
                // Choose this option
                answerYes(videos[currentVideoIdx]);
                // This will exit the function, meaning skip all further logic
                return;
            } else if (answer.equals("no")) {
                // Go to the next option
                currentVideoIdx++;
            } else {
                // Unknown command
                System.out.println(String.format("Command '%s' is not recognized", answer));
                System.out.println(); // Just a blank line for nicer output
            }
        }

        // If no option is selected, print the default message
        System.out.println(noMoreVideosMsg);
    }


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String[] VIDEOS = new String[] { "A", "B", "C", "D" };
        final String NO_MORE_VIDEOS_MSG = "We do not have another options for videos";

        Test test = new Test();
        test.showOptions(VIDEOS, NO_MORE_VIDEOS_MSG);
    }
}