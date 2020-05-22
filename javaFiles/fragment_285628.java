@Override
   public void mouseExited(MouseEvent e) {
        if(!panelA.contains(e.getPoint())){
             panelA.setVisible(false);
        }
        System.out.println(" -  MOUSE EXITED ");
   }