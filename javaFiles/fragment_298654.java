MouseAdapter myMouseAdapter = new MouseAdapter() {
      public void MousePressed(MouseEvent e) {
        label.setVisible(false);
      }
    };
label.addMouseListener(myMouseAdapter);
myMouseAdapter.MousePressed(mouseEventInstance);