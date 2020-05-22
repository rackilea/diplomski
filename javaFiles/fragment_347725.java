private JInternalFrame getFrame1() {
    if (frame1 == null) {
        frame1 = new JInternalFrame("Notepad", true, true, true, true);
        frame1.setBounds(0, 0, 1088, 500);
        frame1.getContentPane().setLayout(new BorderLayout()); 

        // TODO: Add code to fill in the contents by calling getXxx()
        //  for each major contained component OR just creating all the
        //  minor bits that go inside.

        frame1.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frame1.setVisible(true);
    }
    return frame1;
}