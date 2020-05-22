label = new JLabel("hello world"){
     public void paintComponent(Graphics g)
     {
         //draw background
         Color old=g.getColor();
         g.setColor(getBackground());
         g.fillRect(0,0,getWidth(),getHeight());
         g.setColor(old);
         super.paintComponent(g);
     }
};
label.setOpaque(false); // your component is not opaque!