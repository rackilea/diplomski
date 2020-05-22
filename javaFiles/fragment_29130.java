myComboBox.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //some stuff
            }
        }
    });