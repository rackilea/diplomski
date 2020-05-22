mntmStudentRegistration.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (contentPane.getLayout());
            cl.show(contentPane, (String) e.getActionCommand());
        }
    });

    JMenuItem mntmStudentInformation = new JMenuItem("Student Information");
    mntmStudentInformation.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (contentPane.getLayout());
            cl.show(contentPane, (String) e.getActionCommand());
        }
    });