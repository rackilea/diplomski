public class White extends JPanel {
    public White(){
        setBackground( Color.BLACK );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,0);
        gbc.gridx=1;
        gbc.gridy=2;
        JTextArea t1 = new JTextArea(5,15);
        JScrollPane s1 = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(s1,gbc);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0xFF, 0xFF, 0xFF));
    }
    public static void main( String[] args ){
        JFrame frame = new JFrame();
        frame.add( new White() );
        frame.setTitle( "Hello World" );
        frame.setSize( 600, 400 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}