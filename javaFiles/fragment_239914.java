ImageComponent(){
    ImageIcon temp = new ImageIcon("test.png");
    img = temp.getImage();
    setPreferredSize(new Dimension(temp.getIconWidth(),temp.getIconHeight()));
}


@Override
public void paint(Graphics g){
    g.drawImage(img, 0,0 , null);
}