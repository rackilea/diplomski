class AdvancePaint extends JPanel(){
    ArrayList<BufferedImage> layers;
    //Other constructors, variables, initializations not shown

    class AdvancePaint(){
        layers = new ArrayList<BufferedImage>();
    }

    public void addLayer(BufferedImage layer){
        layers.add(layer);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(BufferredImage buf : layers)  //render all layers
            g.drawImage(buf, 0, 0, width, height, null);
    }
}