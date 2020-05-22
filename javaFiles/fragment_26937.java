JDateChooser spinner = new JDateChooser(new JSpinnerDateEditor());
    spinner.addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            System.out.println(e.getPropertyName()
                + ": " + e.getNewValue());
        }
    });
    this.add(spinner);