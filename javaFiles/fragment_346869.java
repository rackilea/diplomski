class JJButton extends JButton {
    {
        addMouseListener(new MouseAdapter(){
        public void mouseEntered(MouseEvent e) {
            if (JJButton.this.getParent()!=null){
                MouseListener[] ml = JJButton.this.getParent().getMouseListeners();
                for (MouseListener l : ml) {
                    l.mouseEntered(e);
                }
            }
        }
        });
    }
    public JJButton(String string) {
        super(string);
    }    
}