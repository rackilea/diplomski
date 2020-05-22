ChangeListener listenerSanteMax = new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();
        if (source instanceof JSpinner) {
            JSpinner spinner = (JSpinner) source;
            SpinnerModel sm = spinner.getModel();
            if (sm instanceof SpinnerNumberModel) {
                SpinnerNumberModel model = (SpinnerNumberModel) sm;
                Number newMaximum = model.getNumber().doubleValue();
                spinnerLimits_sante.setMaximum((Comparable) newMaximum);
            }
        }
    }
};