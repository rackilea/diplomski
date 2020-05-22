/**
 * Invoked when a progress property of "downloading" is received.
 */
@Override
public void propertyChange(PropertyChangeEvent evt) {
    setProgress((int)evt.getNewValue());
}