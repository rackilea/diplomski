firstComboBox.addItemListener(new ItemListener()
    {
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getStateChange()==ItemEvent.SELECTED)
            {
                Object selectedItem = e.getItem(); // new item selected
                // TODO select values for 2nd combobox
                // TODO fill 2nd combobox
                secondComboBox.setEnabled(true);
            }
        }
    });