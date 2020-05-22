list.addMouseListener(new MouseAdapter() {
     public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 2) {
             int index = list.locationToIndex(e.getPoint());
             System.out.println("Double clicked on Item " + index);
          }
     }
 });