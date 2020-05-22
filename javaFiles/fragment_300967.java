package mvpc;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PresentationModel {

    private final IntegerProperty count = new SimpleIntegerProperty();

    public IntegerProperty countProperty() {
        return count ;
    }

    public final int getCount() {
        return countProperty().get();
    }

    public final void setCount(int count) {
        countProperty().set(count);
    }

    public final void increment() {
        setCount(getCount() + 1);
    }
}