class MyPanel extends JPanel{
     public void doRedraw(){
         getTopLevelAncestor().revalidate();
         getTopLevelAncestor().repaint();
     }
}