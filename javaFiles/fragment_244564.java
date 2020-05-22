JFrame frame = new JFrame("JList Test");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    String[] selections = {"Java", "C++", "C", "Scala", "JavaScript"};
    JList list = new JList(selections);
    frame.add(new JScrollPane(list));
    frame.pack();
    frame.setVisible(true);

    MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

            if (mouseEvent.getClickCount() == 1) {
                int index = list.locationToIndex(mouseEvent.getPoint());
                if (index >= 0) {
                    Object obj = list.getModel().getElementAt(index);
                    JOptionPane.showMessageDialog(null, obj);

                }
            }
        }
    };
    list.addMouseListener(mouseListener);

}