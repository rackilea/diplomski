public class EventDAO implements SeverityCalculable  {

    // ...

    @Override
    public String getSeverity() {
        return this.severity;
    }
}