public class BusinessMeeting {
    private Integer businessId;

    public BusinessMeeting(String name, String location, int start, int stop, int business) {
        // because super calls one of the super class constructors(you can overload constructors), you need to pass the parameters required.
        super(name, location, start, stop);
        businessId = business;
    }
}