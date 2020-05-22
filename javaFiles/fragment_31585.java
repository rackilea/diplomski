for (Batcher missile : missiles ){
  missile.setX(missile.getX() + 14); // to make it move
  if (missile.getX() > canvas.gedWidth()) { //check if it's left the screen
    missiles.remove(missile); // Remove it
  }
  else { //perform drawing
    canvas.drawBitmap(missile.getBitmap(), missile.getX(), missile.getY(), null);
  }
}