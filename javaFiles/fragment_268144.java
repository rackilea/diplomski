// Should be called a Panel (since it is one) and use correct case
class Panel1 extends JPanel  {
    Panel1(){
        super();
    }

    // The method to override for custom painting in ANY JComponent
    @Override // handy to check we got the method signature right
    public void paintComponent(Graphics g){
        // paints the background, borders etc.
        super.paintComponent(g);
        // all custom drawing AFTER this line..
    }
}