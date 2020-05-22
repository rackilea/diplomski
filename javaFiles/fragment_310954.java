@XmlRootElement(name="root")
public class SomeRoot{
    private List<Schedule> schedule;

    @XmlElement(name = "Schedule")
    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}