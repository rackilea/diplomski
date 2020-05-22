// Create an ArrayList of Strings, where each string is either "H", "M", or "L"
ArrayList<String> userChoice = new ArrayList<String>()

for (JComboBox box : boxes) {
    // Go through this code once for each JComboBox in boxes
    // The first time through, "box" means the first JComboBox
    // The second time through, "box" is the second JComboBox, etc.
    if (box.getValue().equals("High")) {
         userChoice.add("H");
    } else if (box.getValue().equals("Medium")) {
         userChoice.add("M");
    } else if (box.getValue().equals("Low")) {
         userChoice.add("L")
    }
}