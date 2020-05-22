package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Model {

    private BooleanProperty loggedIn = new SimpleBooleanProperty();

    public final BooleanProperty loggedInProperty() {
        return this.loggedIn;
    }


    public final boolean isLoggedIn() {
        return this.loggedInProperty().get();
    }


    public final void setLoggedIn(final boolean loggedIn) {
        this.loggedInProperty().set(loggedIn);
    }


}