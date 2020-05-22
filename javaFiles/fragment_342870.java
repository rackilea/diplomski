public Mine() {
    initComponents();    
    for(int i = 0; i < hei ; i++)
    {
        for(int j = 0 ; j < wid;j++)
        {
           blocks[i][j] = new JToggleButton();
           blocks[i][j].setSize(jPanel1.getWidth()/wid,jPanel1.getHeight()/hei);
           blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
           blocks[i][j].addActionListener(listen);
           jPanel1.add(blocks[i][j]);  
        }
    }    
}