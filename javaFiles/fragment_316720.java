public class BookingModel {

    private final ObjectProperty<LocalDate> arrival = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> departure = new SimpleObjectProperty<>();
    private final BooleanProperty confirmed = new SimpleBooleanProperty();
    private final ObjectProperty<Screen> screen = new SimpleObjectProperty<>();

    public enum Screen {
        ARRIVAL, DEPARTURE, CONFIRMATION
    }

    public BookingModel() {
        arrival.addListener((obs, oldArrival, newArrival) -> {
            if (departure.get() == null || departure.get().equals(arrival.get()) || departure.get().isBefore(arrival.get())) {
                departure.set(arrival.get().plusDays(1));
            }
        });
    }

   // set/get/property methods for each property...

}