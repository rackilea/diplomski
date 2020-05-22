public void draw(){
 panel=new JPanel(new BorderLayout()){
 @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(img, 0, 0, null);
        }         
 };   
 panel.setBounds(0, 0, img.getWidth(), img.getHeight());
 panel.setPreferredSize(new Dimension(img.getWidth(),obraz.getHeight()));
 JScrollPane scrolls=new JScrollPane(panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

 add(scrolls);
 validate();  
 repaint();     
 }