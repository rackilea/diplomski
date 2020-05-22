JButton button = new JButton("Next");
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        DVDObject obj = getNextDVD();
        populateFields(obj);
    }
});

...

private DVDObject getNextDVD() {
    // gets the next object to display
    // you could call this method for each of the buttons, 
    // passing in an argument that determines which Object
    // to return (first, last, next, previous, whatever)
}

private void populateFields(DVDObject dvd) {
    // write out the values from the object passed in to the
    // fields
}