JPanel dayPanel = new JPanel(new GridLayout(0, 1)); // !!

ArrayList<JCheckBox> Day = new ArrayList<JCheckBox>();
String label[] = { "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8",
        "Day 9", "Day 10", "Day 11", "Day 12", "Day 13", "Day 14", "Day 15", "Day 16",
        "Day 17", "Day 18", "Day 19", "Day 20", "Day 21", "Day 22", "Day 23", "Day 24",
        "Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30", "Day 31", "Day 32",
        "Day 33", "Day 34", "Day 35", "Day 36", "Day 37", "Day 38", "Day 39", "Day 40",
        "Day 41", "Day 42", "Day 43", "Day 44", "Day 45", "Day 46", "Day 47", "Day 48",
        "Day 49", "Day 50", "Day 51", "Day 52", "Day 53", "Day 54", "Day 55", "Day 56",
        "Day 57", "Day 58", "Day 59", "Day 60" };
for (int i = 0; i <= label.length - 1; i++) {
    JCheckBox checkbox = new JCheckBox(label[i]);
    Day.add(checkbox);
    // !! scrollPane.setViewportView(checkbox);
    dayPanel.add(checkbox);  // !!
}

scrollPane.setViewportView(dayPanel);  // !!