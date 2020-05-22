public void MouseClicked(MouseEvent mev) {
     System.out.println("" + mev.getPoint());
     int x = mev.getX();
     int y = mev.getY();
     Place p = new Place(x, y); //!!
     p.setBorder(BorderFactory.createLineBorder(Color.red)); //!!
     mp.add(p);
     mp.repaint();
     mp.validate();
  }