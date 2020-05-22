public class DisplayTime {

    public static void main(String[] args) {

        int seconds = 290;
        int hour = seconds / 60 / 60;
        int minute = seconds / 60 - hour * 60;;

        seconds = seconds % 60;

        System.out.printf("The amount of [ 290 ] seconds are %02d:%02d:%02d\n", hour, minute, seconds);

        seconds = 7650;
        hour = seconds / 60 / 60;
        minute = seconds / 60 - hour * 60;

        seconds = seconds % 60;

        System.out.printf("The amount of [ 7650 ] seconds are %02d:%02d:%02d\n", hour, minute, seconds);
    }
}