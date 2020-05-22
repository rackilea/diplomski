public class Item {
    private final PublishSubject<Void> event = PublishSubject.create();

    private final String data;

    public Item(String data) {
        this.data = data;
    }

    public Observable<Void> event() {
        return event;
    }

    public Void act() {
        System.out.println("Item.act: " + data);
        // do a bunch of stuff
        event.onCompleted();
        return null;
    }
}