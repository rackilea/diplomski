@Override
 public void mouseExited(MouseEvent e) {
    panelA.setBackground(Color.red);
        if (!Sandbox.this.contains(e.getPoint())) {
            panelA.setVisible(false);
        }

        System.out.println(" #  MOUSE EXITED ");
  }