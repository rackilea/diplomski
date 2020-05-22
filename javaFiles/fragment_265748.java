public class Item {

    private final String data;
    private final Observable<ReturnType> event;

    public Item(String data) {
        this.data = data;

        event = Observable
                .fromCallable(this::act);
    }

    public Observable<ReturnType> event() {
        return event;
    }

    public ReturnType act() {
        System.out.println("Item.act: " + data);
        return new ReturnType();
    }
}