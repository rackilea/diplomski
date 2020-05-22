VetoableListSelectionModel vetoableSelection = new VetoableListSelectionModel();
    VetoableChangeListener navigationController = new VetoableChangeListener() {

        public void vetoableChange(PropertyChangeEvent evt)
                throws PropertyVetoException {
            // custom method that implements your condition 
            if (!canSelect((int) evt.getOldValue(), (int) evt.getNewValue()))
                throw new PropertyVetoException("uncommitted changes",
                        evt);
        }

    };
    vetoableSelection.addVetoableChangeListener(navigationController);
    myTable.setSelectionModel(vetoableSelection);