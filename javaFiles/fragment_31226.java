public class Row{
    private final StringProperty audience = new SimpleStringProperty();
    private final List<ObjectProperty<Attendance>> lectures = new ArrayList<>();

    public Row(String audience, int numAttendances) {
        setAudience(audience);
        for (int i = 0 ; i < numAttendances ; i++) {
            lectures.add(new SimpleObjectProperty<>());
        }
    }

    public List<ObjectProperty<Attendance>> getLectures() {
        return lectures ;
    }

    public StringProperty audienceProperty() { 
        return audience ;
    }

    public final String getAudience() {
        return audienceProperty().get();
    }

    public final void setAudience(String audience) {
        audienceProperty().set(audience);
    }
}