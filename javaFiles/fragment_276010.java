@Override
public void propertyChange(PropertyChangeEvent pcEvt) {
    if (pcEvt.getPropertyName().equals(
        ArrayForUpdating.BOUND_PROPERTY)) {
        mList = (pcEvt.getNewValue().toString());
        displayOutput.setText(mList);
    }
}