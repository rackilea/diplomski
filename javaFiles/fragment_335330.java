class CheckListener implements ItemListener {

    private ModelBean model;

    public CheckListener(ModelBean newModel) {
        this.model = newModel;
        model.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                System.out.println(model.getChecked());
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox source = (JCheckBox) e.getSource();
        if (source.isSelected()) {
            model.setChecked(true);
        } else {
            model.setChecked(false);
        }
    }
}