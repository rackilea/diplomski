MouseListener toListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                final int index = fromJList.locationToIndex(e.getPoint());
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        int index = toList.getSelectedIndex();
                        fromModel.addElement(toModel.getElementAt(index));
                        toModel.remove(index);
                    }
                });
            }
        }

    };


}