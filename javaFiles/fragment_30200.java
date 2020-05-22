for (T obj : elipsasCol) {
  if (obj != null && obj.contains(mouse)) {
    // This line                    
    double modulo = Math.sqrt(Math.pow(mouse.x - obj.getCenterX(), 2)
                            + Math.pow(mouse.y - obj.getCenterY(), 2));
  }
}