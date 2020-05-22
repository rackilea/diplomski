public void roll() {
    value = nextValue() ;
    c.setText(Integer.toString(value));
    Icon i = null;
    if (value==1){
        i=new ImageIcon(getClass().getResource("1.png"));
    } else if(value==2){
        i=new ImageIcon(getClass().getResource("2.png"));
    }
    c.setIcon(i);

    repaint() ;
}