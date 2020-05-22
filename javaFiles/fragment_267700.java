public class Opening extends JPanel{
    private JButton but=new JButton();
    private Frames f;

    public Opening(final Frames f){
        this.f = f;
        this.setLayout(null);  // !!!! no don't do this!!!
        this.setBackground(Color.BLACK);
        add(but);
        but.setText("next frame");
        but.setBounds(0, 0, 110, 120);  // and don't do this!
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                // !!Frames f=new Frames();
                f.nxtf();
            }
        });
    }

    public void paint(Graphics g) {
        g.fillRect(110, 120, 110, 120);
    }
}