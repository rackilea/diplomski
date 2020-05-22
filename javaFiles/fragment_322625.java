Rehearsal newrehearsal;
try {
    newrehearsal = new Rehearsal(1, 2, 3);            
} catch (IllegalArgumentException ex) {
    JOptionPane.showMessageDialog(null, "Invalid date input!", "Error", JOptionPane.WARNING_MESSAGE);
    return;
}
// rest of method