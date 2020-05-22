class test extends JFrame {

    private JLabel item1,item2;

    public test(){

        super("First Java app");
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout());
        item1=new JLabel("MY NAME IS XYZ");
        item2=new JLabel("YO");
        item1.setToolTipText("GAME ON");
        panel.add(item1);
        panel.add(item2);
        this.add(panel);

    }
}