ValueModel valueModelNumberPlotRowsJTextField = adapter.getBufferedModel("numberOfPlotRows");
    valueModelNumberPlotRowsJTextField.addValueChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent evt) 
        {
            numPlotRowsJTextField.setBackground(Color.cyan);
        }
    });
    numPlotRowsJTextField = BasicComponentFactory.createIntegerField(valueModelNumberPlotRowsJTextField);