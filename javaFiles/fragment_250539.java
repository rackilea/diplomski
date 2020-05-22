public class JPanelWithBackground extends JPanel { 
Image bg = null; 

public JPanelWithBackground(String url) { 
    try{
        bg = ImageIO.read(getClass().getResourceAsStream(url));
        int height = bg.getHeight(null);
        int width  = bg.getWidth(null);
        Dimension d = new Dimension(width,height);
        this.setSize (width, height);
        this.setMinimumSize ( d );
        this.setOpaque(false); 
    } catch (IOException ex) {
        //TODO: Manage this exception in a better way
            System.err.println(ex);
            System.exit(1);
    }  
} 

@Override
public void paintComponent(Graphics g) { 
    super.paintComponent(g);
    if (bg != null)
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), null);
}
}