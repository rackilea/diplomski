synchronized(elipsasCol){
for (int i = 1; i < elipsasCol.size(); i++) {
  if (elipsasCol.get(i) != null && elipsasCol.get(i).contains(mouse)) {
    // This line                    
    double modulo = Math.sqrt(Math.pow(mouse.x - elipsasCol.get(i).getCenterX(), 2)
                            + Math.pow(mouse.y - elipsasCol.get(i).getCenterY(), 2));
  }
}