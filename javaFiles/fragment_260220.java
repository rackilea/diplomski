public void mouseReleased(MouseEvent e) {
  if ( this.value == NONE ) {
    if ( currentTurn == Turn.X ) {
      this.value = X;
    }
    else {
      this.value = O;
    }
  }
  super.mouseReleased();
}