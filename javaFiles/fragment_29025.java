private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
    if(evt.getStateChange() == ItemEvent.SELECTED) {
        String selected_item = jComboBox1.getSelectedItem().toString();
        switch(selected_item) {
        case "Japan":
            // do something when japan is selected.
            break;

        case "China":
            // do something when China is selected.
            break;
        }
    }
}