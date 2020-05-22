private int rollValue;

public void setRollValue(int val) { this.rollValue = val; }

public void paint(Graphics g) {
  super.paint(g);

  switch (rollValue) {
  ...
  }
}

public void updateVal(int i){
  setRollValue(i);
  repaint();
}