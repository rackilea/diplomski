public void initGUI(Person person) {
    frame.getContentPane().removeAll();
    frame.repaint();
    frame.revalidate();

    frame.setContentPane(mainPanel);
    frame.repaint();
    frame.revalidate();
    frame.setVisible(true);
}