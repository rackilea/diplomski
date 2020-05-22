public void setColVals(Color colVals) {
   this.colVals = colVals;
}

@Override
protected void paintComponent(Graphics g)  {   

    super.paintComponent(g);

    g.setColor(colVal);
    // System.out.println(colVal);
    g.fillOval( px, py, 15, 15 );
}