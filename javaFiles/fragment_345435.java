public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        System.out.println("Go and run 5k");
        return "Go and run 5k";
    }
}