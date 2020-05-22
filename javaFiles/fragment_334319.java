@Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("Mouse click event on ChildPanel");
      this.frame.mouseClicked(e);
      getParent().mouseClicked(e);
   }