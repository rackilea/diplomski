public AdminClass() {

    panel.setLayout(new GridLayout(3, 1));

    panel.add(new JLabel("Welcome to Admin Panel"));

    btnNewButton.addActionListener(this);
    panel.add(btnNewButton);

    panel.add(new JLabel("Existing Projects"));

    List<String> projectNameList = new ArrayList<String>();
    for (int index = 0; index < 1000; index++) {
        projectNameList.add("Project " + index);
    }
    projectNames = projectNameList.toArray(new String[0]);

    // Adding buttons to the project
    buttons = new JButton[projectNameList.size()];
    try {
        for (int i = 0; i < projectNames.length; i++) {
            buttons[i] = new JButton(projectNames[i]);

            btnPnl1.add(buttons[i]);
            buttons[i].addActionListener(this);

        }
    } catch (Exception e2) {
        JOptionPane.showMessageDialog(null, e2);
    }

    frame.add(panel, BorderLayout.NORTH);
    frame.add(new JScrollPane(btnPnl1), BorderLayout.CENTER);

    frame.setVisible(true);
    frame.setSize(500, 500);

}