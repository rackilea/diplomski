ChangeListener listenerSanteMax = new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        Number newMaximum = spinnerLimits_sante_max.getNumber().doubleValue();
        spinnerLimits_sante.setMaximum((Comparable) newMaximum);
    }
};