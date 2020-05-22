list.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
        int index = list.locationToIndex(e.getPoint());
        System.out.println("MouseListener index: " + index);
     }
  });