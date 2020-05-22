import javafx.geometry.Pos;
import javafx.scene.control.ListCell;

public class CenteredListCell<T> extends ListCell<T> {

    /** Default constructor */
    public CenteredListCell() {
        setMaxWidth(Double.POSITIVE_INFINITY);
        setAlignment(Pos.BASELINE_CENTER);
    }

    @Override
    public void updateItem(final T item, final boolean empty) {
        super.updateItem(item, empty);
        setText(empty || item == null ? null : item.toString());
    }

}