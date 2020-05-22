class MeinMausAdapter extends MouseAdapter {

     @Override  // this will cause a compiler error
     public void mousPressed(MouseEvent e) { // until you fix this spelling!
        ButtonModel btnmdl = btngrp.getSelection();
        if (btnmdl == null) {
           System.out.println("btn model is null");
           return;
        }
        actionCmd = btnmdl.getActionCommand();
        System.out.println(actionCmd);
        xpos = e.getX();
        ypos = e.getY();
        // JOptionPane.showInputDialog(this);
        repaint();
     }
  }