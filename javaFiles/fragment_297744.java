public void mouseClicked(MouseEvent evt) {

    if ((evt.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {
      System.out.println("middle" + (evt.getPoint()));
    }

 }