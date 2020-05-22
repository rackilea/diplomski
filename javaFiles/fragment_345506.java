public void ActionPerformed(ActionEvent h){
    if(h.getSource() == upButton) {
        --y1;
    }
    else if(h.getSource() == downButton){
        ++y1;
    }
    else if(h.getSource() == leftButton){
        --x1;
    }
    else if(h.getSource() == rightButton){
        ++x1;
    }
   repaint();
}