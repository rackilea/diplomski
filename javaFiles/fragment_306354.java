public class map extends JPanel {

    ImageIcon img; 

public map (ImageIcon img){
    this.img = img;
    Dimension size = new Dimension(getWidth(),getHeight());
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);  
}
public void paintComponent(Graphics g){
    g.drawImage(img.getImage(), 0, 0, null);
}