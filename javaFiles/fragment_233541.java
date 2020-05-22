class MouseLis extends MouseAdapter{
    public void MouseClicked(MouseEvent mev){
        int x = mev.getX();
        int y = mev.getY();
        Place p = new Place(x,y);
        mp.add(p);
        mp.repaint();
        mp.validate();
    }
}