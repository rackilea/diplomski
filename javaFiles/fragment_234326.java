import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;

public class InputFilter<T> implements ChangeListener<String> {

private ComboBox<T> box;
private FilteredList<T> items;
private boolean upperCase;
private int maxLength;
private String restriction;
private int count = 0;

/**
 * @param box
 *            The combo box to whose textProperty this listener is
 *            added.
 * @param items
 *            The {@link FilteredList} containing the items in the list.
 */
public InputFilter(ComboBox<T> box, FilteredList<T> items, boolean upperCase, int maxLength,
        String restriction) {
    this.box = box;
    this.items = items;
    this.upperCase = upperCase;
    this.maxLength = maxLength;
    this.restriction = restriction;
    this.box.setItems(items);
    this.box.showingProperty().addListener(new ChangeListener<Boolean>() {

        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue == false) {
                items.setPredicate(null);
                box.getParent().requestFocus();
            }

        }

    });
}

public InputFilter(ComboBox<T> box, FilteredList<T> items, boolean upperCase, int maxLength) {
    this(box, items, upperCase, maxLength, null);
}

public InputFilter(ComboBox<T> box, FilteredList<T> items, boolean upperCase) {
    this(box, items, upperCase, -1, null);
}

public InputFilter(ComboBox<T> box, FilteredList<T> items) {
    this(box, items, false);
}

@Override
public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    StringProperty value = new SimpleStringProperty(newValue);
    this.count++;
    System.out.println(this.count);
    System.out.println(oldValue);
    System.out.println(newValue);
    // If any item is selected we save that reference.
    T selected = box.getSelectionModel().getSelectedItem() != null
            ? box.getSelectionModel().getSelectedItem() : null;

    String selectedString = null;
    // We save the String of the selected item.
    if (selected != null) {
        selectedString =  this.box.getConverter().toString(selected);
    }

    if (upperCase) {
        value.set(value.get().toUpperCase());
    }

    if (maxLength >= 0 && value.get().length() > maxLength) {
        value.set(oldValue);
    }

    if (restriction != null) {
        if (!value.get().matches(restriction + "*")) {
            value.set(oldValue);
        }
    }

    // If an item is selected and the value in the editor is the same
    // as the selected item we don't filter the list.
    if (selected != null && value.get().equals(selectedString)) {
        // This will place the caret at the end of the string when
        // something is selected.
        System.out.println(value.get());
        System.out.println(selectedString);
        Platform.runLater(() -> box.getEditor().end());
    } else {
        items.setPredicate(item -> {
            System.out.println("setPredicate");
            System.out.println(value.get());
            T itemString = item;
            if (this.box.getConverter().toString(itemString).toUpperCase().contains(value.get().toUpperCase())) {
                return true;
            } else {
                return false;
            }
        });
    }

    // If the popup isn't already showing we show it.
    if (!box.isShowing()) {
        // If the new value is empty we don't want to show the popup,
        // since
        // this will happen when the combo box gets manually reset.
        if (!newValue.isEmpty() && box.isFocused()) {
            box.show();
        }
    }
    // If it is showing and there's only one item in the popup, which is
    // an
    // exact match to the text, we hide the dropdown.
    else {
        if (items.size() == 1) {
            // We need to get the String differently depending on the
            // nature
            // of the object.
            T item = items.get(0);

            // To get the value we want to compare with the written
            // value, we need to crop the value according to the current
            // selectionCrop.
            T comparableItem = item;

            if (value.get().equals(comparableItem)) {
                Platform.runLater(() -> box.hide());
            }
        }
    }

    box.getEditor().setText(value.get());
}