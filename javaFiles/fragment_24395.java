final JRadioButton spinnerButton = new JRadioButton("Spinner Enabled");
    spinnerButton.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (spinnerButton.isSelected()){
                spinner.setEnabled(true);
            } else {
                spinner.setEnabled(false);
            }
        }
    });