import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

public class Test {

    public static void main(String[] args) {
        ObservableSet<String> set = FXCollections.observableSet();
        ErrorLoggingSetChangeListener<String> listener = c -> {
            if (c.wasAdded()) {
                int i = Integer.parseInt(c.getElementAdded());
                System.out.println("Value added: "+i);
            }
        };
        set.addListener(listener);

        set.add("42");
        set.add("What do you get when you multiply 6 by 9?");
    }

}