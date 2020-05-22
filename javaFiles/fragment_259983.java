import javafx.event.Event;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * This is a utility class to create a Widow Event handler
 * in such way that when a child window shows, a parent (owner)
 * stage get locked; and when the child window hides, the parent
 * stage get unlocked.
 *
 * @author David Vidal
 * @version 1.0
 * @since 1.0
 */
public final class WindowsModality {
    /*=================*
     * Private fields. *
     *=================*/
    /**
     * The parent stage.
     */
    private final Stage owner;

    /*===============*
     * Constructors. *
     *===============*/

    /**
     * Initialize an instance with given parameters.
     *
     * @param owner parent stage.
     * @param child child stage.
     */
    public WindowsModality(Stage owner, Stage child) {
        this.owner = owner;
        child.addEventHandler(WindowEvent.WINDOW_HIDDEN, this::childHidden);
        child.addEventHandler(WindowEvent.WINDOW_SHOWN, this::childShown);
    }

    /*==================*
     * Implementations. *
     *==================*/

    /**
     * Implementation of functional interface EventHandler,
     * used to know when the child window is closed/hidden.
     *
     * @param event from {@link javafx.event.EventHandler#handle(Event)}
     */
    private void childHidden(WindowEvent event) {
        if (!event.isConsumed()) {
            owner.getScene().getRoot().setDisable(false);
        }
    }

    /**
     * Implementation of functional interface EventHandler,
     * used to know when the child window is shown.
     *
     * @param event from {@link javafx.event.EventHandler#handle(Event)}
     */
    private void childShown(WindowEvent event) {
        if (!event.isConsumed()) {
            owner.getScene().getRoot().setDisable(true);
        }
    }
}