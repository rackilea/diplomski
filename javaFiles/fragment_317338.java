import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class RebindingTest {
    public static void main(String[] args) {
        StringProperty text = new SimpleStringProperty();
        StringProperty value1 = new SimpleStringProperty();
        StringProperty value2 = new SimpleStringProperty();

        text.addListener((obs, oldValue, newValue) -> System.out.printf("text changed from %s to %s%n", oldValue, newValue));
        text.bind(value1);

        value1.set("Set value 1");
        text.bind(value2);
        value2.set("Set value 2");
        value1.set("Reset value 1");

    }
}