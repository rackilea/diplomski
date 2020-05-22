public Ships() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, 1363, 730);
    contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setVisible(true);

    l5.setIcon(new ImageIcon("C:\\Users\\The Wimpster\\Desktop\\images22.png"));
    // 
    contentPane .add(l5);
    l5.setBounds(0, 10, 75, 50);//this label is supposed to move with mouse pointer
    contentPane .addMouseMotionListener(new MouseAdapter(){ 
        public void mouseMoved(MouseEvent e){
            p = e.getX();
            l = e.getY();
            l5.setBounds(p,l,150,50); 
        }
    }); 
}