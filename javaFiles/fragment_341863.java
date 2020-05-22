spinner.addChangeListener(new ChangeListener() {

    Object lastValue;

    @Override
    public void stateChanged(ChangeEvent evt) {

        if (lastValue != null && !spinner.getValue().equals(lastValue)) {
           // expensive code calls here!
        }
        lastValue = spinner.getValue();
    }
});