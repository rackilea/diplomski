public class LogEntry {
    private SimpleObjectProperty<LocalDateTime> timestamp = new SimpleObjectProperty<>();
    private SimpleStringProperty action = new SimpleStringProperty();
    public final SimpleObjectProperty<LocalDateTime> timestampProperty() {
        return this.timestamp;
    }

    public final java.time.LocalDateTime getTimestamp() {
        return this.timestampProperty().get();
    }

    public final void setTimestamp(final java.time.LocalDateTime timestamp) {
        this.timestampProperty().set(timestamp);
    }

    public final SimpleStringProperty actionProperty() {
        return this.action;
    }

    public final java.lang.String getAction() {
        return this.actionProperty().get();
    }

    public final void setAction(final java.lang.String action) {
        this.actionProperty().set(action);
    }
}