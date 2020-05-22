public static void main(String[] arg){
    JPanel p = (new JPanel());
    p.add( new Object(){
        <T extends AbstractButton> T f(T x){
            x.setEnabled(false);
            return x;
        }}.f(new JButton("B")) );
    JFrame w = new JFrame("W");
    w.add(p);
    w.pack();
    w.setVisible(true);
}