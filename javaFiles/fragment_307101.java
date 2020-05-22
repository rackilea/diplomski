public Cell(int size, int dt, int dl) {
     numCells++;
     //.... code deleted

     // !!this.color = new Color(Color.BLACK); // *** won't compile!
     color = Color.black;

     //.... code deleted

     this.setOpaque(true);
     setBorder(BorderFactory.createLineBorder(Color.red, 2));  // **** add this
  }