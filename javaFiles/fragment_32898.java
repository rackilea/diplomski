String tree = "│           ┌── K\n"
        + "│       ┌── F\n"
        + "│       │   │   ┌── L\n"
        + "│       │   └── J\n"
        + "│   ┌── C\n"
        + "│   │   │   ┌── I\n"
        + "│   │   └── E\n"
        + "└── A\n"
        + "    │       ┌── H\n"
        + "    │   ┌── D\n"
        + "    │   │   └── G\n"
        + "    └── B";
JTextArea ta = new JTextArea(15, 25);
ta.setText(tree);
ta.setFont(new Font("Monospaced", Font.PLAIN, 13));
JFrame frame = new JFrame();
frame.add(new JScrollPane(ta));
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);