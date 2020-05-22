import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ImageButton extends javax.swing.JButton implements MouseListener{

private MouseListener mouseListener = null;
private BufferedImage bufferedImage;
private int minAlpha = 0x0;
private boolean userMouseListener = false;

public ImageButton(ImageIcon ic){
    super();
    setPreferredSize(new Dimension(ic.getIconWidth(), ic.getIconHeight()));
    setImage(ic);
    addMouseListener(this);
}
protected BufferedImage imageIconToBufferedImage(ImageIcon a){
    BufferedImage bi = new BufferedImage(a.getIconWidth(), a.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = (Graphics2D) bi.getGraphics();
    g2d.drawImage(a.getImage(), 0,0,null);
    g2d.dispose();
    return bi;
}
public void setImage(ImageIcon ic){
    bufferedImage = imageIconToBufferedImage(ic);
    repaint();
}
protected void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    RenderingHints _rh = g2d.getRenderingHints();
    g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.drawImage(bufferedImage, 0, 0, null);
    g2d.setRenderingHints(_rh);
}
protected void setMinimumDetectionAlpha(int alpha){
    minAlpha = alpha == 0 ? 1 : alpha;
    minAlpha =  minAlpha % 0x000000FF << 0x00000010;
}
protected void processMouseEvent(MouseEvent e) {
    if(checkInBounds(e.getX(), e.getY())){
        switch(e.getID()){
            case MouseEvent.MOUSE_CLICKED:  mouseListener.mouseClicked(e);      break;
            case MouseEvent.MOUSE_ENTERED:  mouseListener.mouseEntered(e);      break;
            case MouseEvent.MOUSE_EXITED:   mouseListener.mouseExited(e);       break;
            case MouseEvent.MOUSE_PRESSED:  mouseListener.mousePressed(e);      break;
            case MouseEvent.MOUSE_RELEASED: mouseListener.mouseReleased(e);     break;
        }           
        e.consume();            
    }
}
public void addMouseListener(MouseListener a){
    if(!userMouseListener)
        super.addMouseListener(a);
    else
        mouseListener = a;
    userMouseListener = true;       
}
protected boolean checkInBounds(int x, int y){
    try{        
        if((bufferedImage.getRGB(x, y) & 0xFF000000)>>>4 >= (minAlpha > 0 ? minAlpha : 0x08800000))
            return true;
        else
            throw new Exception();
    }catch(Exception e){
        return false;
    }
}
@Override
public void mouseClicked(MouseEvent e)  {       processMouseEvent(e);       }
@Override
public void mouseEntered(MouseEvent e)  {       processMouseEvent(e);       }
@Override
public void mouseExited(MouseEvent e)   {       processMouseEvent(e);       }
@Override
public void mousePressed(MouseEvent e)  {       processMouseEvent(e);       }
@Override
public void mouseReleased(MouseEvent e) {       processMouseEvent(e);   }
}