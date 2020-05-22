table.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        int row = table.rowAtPoint(p);
        int col = table.columnAtPoint(p);

        System.out.printf("row, col: [%d, %d]%n", row, col);

        // show pop-up menu here

     }
  });