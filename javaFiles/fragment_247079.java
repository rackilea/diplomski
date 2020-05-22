public abstract class BaseHolidayPackageVariant {
    private int cost;

    public Map<String, String> getDetails() {
        HashMap<String, String> details = new HashMap<String, String>();
        details.put("cost", String.format("%.2f", cost / 100.0));
        return details;
    }
}

public class FlightHolidayPackageVariant extends BaseHolidayPackageVariant {
    private Destination originCity;

    @Override
    public Map<String, String> getDetails() {
        Map<String, String> details = super.getDetails();
        details.put("origin city", originCity.getName());
        return details;
    }
}