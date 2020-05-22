@Root
public class Alerts {

    @ElementList(inline=true)
    private List<Alert> Alerts;

    public List<Alert> getAlerts() {
        return this.Alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.Alerts = alerts;
    }

}