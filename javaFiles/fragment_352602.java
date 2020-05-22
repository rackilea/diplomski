public class Example {

    public static class Item {
        int id;
    }

    public static void main(String[] args) {
        getIds()
                .flatMapIterable(ids -> ids) // Converts your list of ids into an Observable which emits every item in the list
                .flatMap(Example::getItemObservable) // Calls the method which returns a new Observable<Item>
                .subscribe(item -> System.out.println("item: " + item.id));
    }

    // Simple representation of getting your ids.
    // Replace the content of this method with yours
    private static Observable<List<Integer>> getIds() {
        return Observable.just(Arrays.<Integer>asList(1, 2, 3));
    }

    // Replace the content of this method with yours
    private static Observable<Item> getItemObservable(Integer id) {
        Item item = new Item();
        item.id = id;
        return Observable.just(item);
    }
}