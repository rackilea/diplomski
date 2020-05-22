phoneBrandCombo.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent arg0) {
            if(arg0.getStateChange() == ItemEvent.SELECTED){
                Object object = ((JComboBox)arg0.getSource()).getSelectedItem();
                //loadDataFromDBToTable(object);
            }
        }
    });