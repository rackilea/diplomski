import java.util.*;
import javafx.collections.*;
import javafx.collections.transformation.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        ObservableList<String> obsList = FXCollections.observableList(list);
        FilteredList<String> filteredList = new FilteredList<>(obsList);

        System.out.println("INITIAL STATE");
        System.out.printf("\tList: %s%n", list);
        System.out.printf("\tFilteredList: %s%n", filteredList);

        list.add("Goodbye");
        list.add("World");

        System.out.println("AFTER ADDING ELEMENTS");
        System.out.printf("\tList: %s%n", list);
        System.out.printf("\tFilteredList: %s%n", filteredList);

        list.set(0, "Foo");
        list.set(1, "Bar");

        System.out.println("AFTER REPLACING ELEMENTS");
        System.out.printf("\tList: %s%n", list);
        System.out.printf("\tFilteredList: %s%n", filteredList);
    }

}