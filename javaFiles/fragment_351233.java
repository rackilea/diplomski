class DrawingSpace extends JPanel
{
    private BufferedImage buf;

    public DrawingSpace(){
        setPreferredSize(new Dimension(200, 200));
        buf = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        drawOnBuffer();
    }

    public void drawOnBuffer(){
        Graphics g = buf.createGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(0,0,200,200);
        g.setColor(Color.RED);
        g.fillOval(50,50,100,100);
        g.dispose();
    }

    public void saveBufferAsImage(String pathname){
        String fmt = "";
        if(!(pathname == null || pathname.equals(""))){
            fmt = pathname.substring(pathname.lastIndexOf(".")+1);
            File outputfile = new File(pathname);
            try{
                ImageIO.write(buf, fmt, outputfile);        
            }catch(IOException ioe){System.out.println("Unable to save file");}
        }       
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(buf, 0, 0, 200, 200, null); //Only for user to see
    }
}