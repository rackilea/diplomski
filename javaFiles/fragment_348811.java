private void comboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {                                                     

    if (java.awt.event.ItemEvent.DESELECTED == evt.getStateChange()) {

        String valueBeforeDeselection = evt.getItem().toString();
        // Do something if needed

    } else if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

        String valueAfterSelection = evt.getItem().toString();
        // Set the values of the ComboBox2
    }
}