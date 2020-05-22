public static class AnimatorWindow extends JPanel implements MouseListener{
    public AnimatorWindow(){
        setBackground(Color.gray);
        setForeground(Color.white);
        //add the listener
        addMouseListener(this);
    }
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        //You should not alter the Graphics object passed in
        Graphics2D g = (Graphics2D) page.create();

        //draw your stuff with g
        g.drawString("Stickmen Animation Station", 150, 15);
        .......

        //finish
        g.dispose();
    }


    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
        //implement your clicking here
        //Use e.getX() and e.getY() to get the click position
    }
}