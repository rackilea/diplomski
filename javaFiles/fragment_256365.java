public static void main(String args[]) throws Exception {
class JFrameTypeLocking extends JFrame {
    Point locked=null;
    public JFrameTypeLocking(String string) {
        super(string);
        super.addComponentListener(new ComponentAdapter(){
            public void componentMoved(ComponentEvent e) {
                if (locked!=null) JFrameTypeLocking.this.setLocation(locked);
            }});
    }
    public void lockLocation() {
        locked=super.getLocation();
    }
}
JFrameTypeLocking f = new JFrameTypeLocking("");
f.setSize(300,300);
f.setLocation(300,300);
f.setVisible(true);
f.lockLocation();
}