// The gui method we want to synchronize
public void collectInput() {

    synchronized(this) {

        // Collect fields
        name = nameField.getText();
        age = ageField.getText();
        date = dateField.getText();

        // Notify waiter that our business is complete  
        notify();
    }
}