jTable.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                data = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);
                System.out.println(data);
            }
        }

    });