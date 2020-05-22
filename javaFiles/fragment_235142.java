package application;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;

public class ExtendedButton extends Button {

    public final ObjectProperty<Enum<?>> buttonState = new SimpleObjectProperty<>(ButtonState.NORMAL);

    public final ObjectProperty<Enum<?>> buttonStateProperty() {
        return this.buttonState;
    }


    public final Enum<?> getButtonState() {
        return this.buttonStateProperty().get();
    }


    public final void setButtonState(final Enum<?> buttonState) {
        this.buttonStateProperty().set(buttonState);
    }

    public ExtendedButton() {
        super();
        styleProperty().bind(Bindings.
                when(buttonState.isEqualTo(ButtonState.CRITICAL)).
                then("-fx-base: red;").
                otherwise(""));


    }

}