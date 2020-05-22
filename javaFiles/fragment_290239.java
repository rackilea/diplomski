import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Painter extends JPanel {
    BufferedImage offi;
    Graphics offg;
    private double x1,y1,x2,y2;

    Painter(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }
    @Override
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(offi,0,0,this);
    }

    private void draw(){
        if(offi == null){
            offi = (BufferedImage)createImage(getWidth(),getHeight());
            offg = offi.getGraphics();
            offg.setColor(Color.black);
            offg.fillRect(0,0,getWidth(),getHeight());
        }  
        offg.setColor(Color.RED);
        offg.fillRect((int)x1,(int)y1,1,1);
    }

    public void drawLine() {
        double DX = (x2-x1);
        double DY = (y2-y1);

        double steps = (Math.abs(DX) > Math.abs(DY) ) ? Math.abs(DX) : Math.abs(DY);

        double xIncrement = DX/(steps);
        double yIncrement = DY/(steps);        
        for (int i = 0; i < steps; ++i) {           
            x1 += xIncrement;
            y1 += yIncrement;

            /*try{
                Thread.sleep(50); //sleep if you want it to be animated
            }catch(InterruptedException e){
                e.printStackTrace();
            }*/
            draw();            
            repaint();
        }  
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame jFrame = new JFrame("Graphics");
            Painter dpl = new Painter(0,0,533,333);
            jFrame.add(dpl);
            jFrame.setSize(720,480);
            jFrame.setResizable(false);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            new Thread(() -> dpl.drawLine()).start();;
        });
    }

}