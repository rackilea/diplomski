import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint{

    public static void main(String[] args){
            gui g = new gui();
            g.setVisible(true);

    }

}

 class gui extends JComponent implements ActionListener{
    JButton red, green, blue, clear;
    Image image;
    Graphics2D draw;
    int x, y, prevX, prevY;

    gui(){
            JFrame frame = new JFrame("Paint");
            Container content = frame.getContentPane();
            content.setLayout(new BorderLayout());
            setDoubleBuffered(false);

            JPanel panel = new JPanel();
            content.add(panel, BorderLayout.SOUTH);
            panel.setPreferredSize(new Dimension(32, 68));
            panel.setMinimumSize(new Dimension(32, 68));
            panel.setMaximumSize(new Dimension(32, 68));


            red = new JButton("Red");
            green = new JButton("Green");
            blue = new JButton("Blue");
            clear = new JButton("Clear");

            red.setPreferredSize(new Dimension(50, 16));
            green.setPreferredSize(new Dimension(50,16));
            blue.setPreferredSize(new Dimension(50, 16));

            panel.add(red);
            panel.add(green);
            panel.add(blue);
            panel.add(clear);

            panel.setVisible(true);

            red.addActionListener(this);
            green.addActionListener(this);
            blue.addActionListener(this);
            clear.addActionListener(this);

            frame.setSize(500, 500);

            frame.setVisible(true)            ;


            addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                            prevX = e.getX();
                            prevY = e.getY();
                    }

            });

            addMouseMotionListener(new MouseMotionAdapter(){
                    public void mouseDragged(MouseEvent e){
                            x = e.getX();
                            y = e.getY();
                            draw.drawLine(prevX, prevY, x, y);
                            repaint();
                            prevX = x;
                            prevY = y;

                    }


            });

    }


    public void paintComponent(Graphics g){

           if(image==null){
                    image = createImage(getSize().width, getSize().height);

                    draw = (Graphics2D)image.getGraphics();

                    draw.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    draw.setPaint(Color.white);
                    draw.fillRect(0, 0, getSize().width, getSize().height);
                    draw.setPaint(Color.black);
                    repaint();
           }

            g.drawImage(image, 0, 0, null);

    }


    public void actionPerformed(ActionEvent e) {
        if( e.getSource()==red){
            draw.setPaint(Color.red);
            repaint();
        }
        if( e.getSource()==green){
            draw.setPaint(Color.green);
            repaint();
        }
        if( e.getSource()==blue){
            draw.setPaint(Color.blue);
            repaint();
        }
        if( e.getSource()==clear){
            draw.setPaint(Color.white);
            draw.fillRect(0, 0, getSize().width, getSize().height);
            draw.setPaint(Color.black);
            repaint();
        }


    }


 }