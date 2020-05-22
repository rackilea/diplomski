public void crtaj(Graphics2D g2d){
    dole = Util.openImage("stub_dole.png");
    gore = Util.openImage("stub_gore.png");
    g2d.drawImage(dole, dx, dy, null);
    g2d.drawImage(gore, dx, -(560-dy), null);
}