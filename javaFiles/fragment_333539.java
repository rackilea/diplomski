import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;

public class ListUpdateTest {

    public static void main(String[] args) {

        ObservableList<Foo> fooList = FXCollections.observableArrayList(foo -> new Observable[] { foo.nameProperty() });
        Foo fooA = new Foo("Hello");
        Foo fooB = new Foo("Kitty");
        fooList.add(fooA);
        fooList.add(fooB);

        fooList.addListener((Change<? extends Foo> c) -> {
             while (c.next()) {
                if (c.wasUpdated()) {
                    int start = c.getFrom() ;
                    int end = c.getTo() ;
                    for (int i = start ; i < end ; i++) {
                        System.out.println("Element at position "+i+" was updated to: " +c.getList().get(i).getName() );
                    }
                }
            }
        });

        fooB.setName("Mickey");
    }

    public static class Foo {
        private StringProperty name = new SimpleStringProperty();
        public final StringProperty nameProperty() { return name; }
        public final String getName() { return name.get(); }
        public final void setName(String n) { name.set(n); }
        public Foo(String fooName) { setName(fooName); }
    }
}