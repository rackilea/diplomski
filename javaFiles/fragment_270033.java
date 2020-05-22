public void render(Graphics g){
    g.drawString("bro wat", resources, resources);
    g.setColor(Color.gray);
    g.fill(this);
    g.drawString(Integer.toString(resources), this.width/2, this.height/2);
} // end update