class RectangleDrawer extends JPanel{
    ArrayList<Rectangle> rList = new ArrayList()<Rectangle>;
    public void addRectangle(Rectangle rect){
        rList.add(rect);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i<rList.size(); r++){
            g.drawRectangle(rList.get(i));
        }
    }
}