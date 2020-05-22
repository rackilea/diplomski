public void actionPerformed(ActionEvent e) {
        Object newItem = getEditor().getItem(); // get edited's item
        setPopupVisible(false);
        getModel().setSelectedItem(newItem);   // model set the item as selected
        String oldCommand = getActionCommand();
        setActionCommand("comboBoxEdited");
        fireActionEvent();
        setActionCommand(oldCommand);
    }