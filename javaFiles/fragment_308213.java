public class Player {
    private Event event;

    private int id;

    ...

    public void setEvent(Event event) throws Exception {
        if (!this.event.terminated) {
            throw new Exception("Player has an event to be associated with");
        } else {
            this.event = event;
        } 
    }
}