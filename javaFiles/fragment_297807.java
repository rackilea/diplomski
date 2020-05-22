import javafx.collections.ListChangeListener.Change;

public class ObservableQueueTest {
    public static void main(String[] args) {
        ObservableQueue<String> oq = new ObservableQueue<>();
        oq.addListener((Change<? extends String> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    System.out.println("Added: "+change.getAddedSubList());
                }
                if (change.wasRemoved()) {
                    System.out.println("Removed: "+change.getRemoved());
                }
                if (change.wasUpdated()) {
                    System.out.println("Updated: "+oq.subList(change.getFrom(), change.getTo()));
                }
                if (change.wasReplaced()) {
                    System.out.println("Replaced");
                }
            }
        });

        oq.offer("One");
        oq.offer("Two");
        oq.offer("Three");

        System.out.println("Peek: "+oq.peek());
        System.out.println("Remove...");
        System.out.println(oq.remove());

        System.out.println("Element:");
        System.out.println(oq.element());

        System.out.println("get(1): "+oq.get(1));

        System.out.println("Poll: ");
        System.out.println(oq.poll());

        System.out.println("Poll again:");
        System.out.println(oq.poll());

        System.out.println("Poll should return null:");
        System.out.println(oq.poll());

        System.out.println("Element should throw exception:");
        System.out.println(oq.element());
    }

}