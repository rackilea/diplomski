table.addMouseListener(new MouseAdapter() {

         public void mouseClicked(MouseEvent e) {
           int row = table.rowAtPoint(e.getPoint());
           int col = table.columnAtPoint(e.getPoint());
           String input = JOptionPane.showInputDialog(getContentPane(), "message");

           //store data based on row and column
      }
  });