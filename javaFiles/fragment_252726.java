package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DataModel {
    private ObjectProperty<User> currentUser = new SimpleObjectProperty<>();

    public final ObjectProperty<User> currentUserProperty() {
        return this.currentUser;
    }

    public final User getCurrentUser() {
        return this.currentUserProperty().get();
    }

    public final void setCurrentUser(final User currentUser) {
        this.currentUserProperty().set(currentUser);
    }



    // other properties, etc...
}