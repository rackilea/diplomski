public static void main(String[] args) {
    Age age = new Age();
    String startingAgeAsString = JOptionPane.showInputDialog("Enter your current age in years(ex: 21):");
    String retirementAgeAsString = JOptionPane.showInputDialog("Enter the age you wish to retire at:");
    try {
        age.setStartingAge(Integer.parseInt(startingAgeAsString));
    } catch (NumberFormatException e) {}
    try {
        age.setRetirementAge(Integer.parseInt(retirementAgeAsString));
    } catch (NumberFormatException e) {}
    JOptionPane.showMessageDialog(null, age);
}