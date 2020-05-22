MouseListener ml = new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent evt) {
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            if (list.getSelectedIndex() != -1) {
                int index = list.locationToIndex(evt.getPoint());
                System.out.println("You clicked item  @ " + index);
            }
        }
    }
}

list.addMouseListener(ml);