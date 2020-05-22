public void roll() {
    value = nextValue() ;
    if (value==1){
        Icon i=new ImageIcon(getClass().getResource("1.png"));
        c= new JButton(i);
        add(c);
    } else if(value==2){
        Icon im=new ImageIcon(getClass().getResource("2.png"));
        c= new JButton(im);
        add(c);
    }

    repaint() ;
}