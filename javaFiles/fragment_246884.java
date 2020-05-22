package stackoverflow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SplashScreen extends JFrame
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new SplashScreen();
            }
        });
    }    

    private PaintPanel paintPanel;

    public SplashScreen()
    {
        setTitle("BlueJay");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.BLACK);
        getContentPane().setLayout(new BorderLayout());

        paintPanel = new PaintPanel();
        getContentPane().add(paintPanel, BorderLayout.CENTER);

        setSize(900,600);
        setLocationRelativeTo(null);
        setFocusable(true);
        requestFocus();
        setVisible(true);

        startAnimation();
    }

    void startAnimation()
    {
        Thread thread = new Thread(new Runnable()
        {
            int x = 100;
            int y = 100;
            int w = 0;
            int h = 0;

            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                    return;
                }

                while (true)
                {
                    if (y == 200)
                    {
                        // new MainMenu_BlueJay().setVisible(true);
                        dispose();
                    }

                    x += 2;
                    y += 1;
                    w += 1;
                    h += 1;
                    paintPanel.setImageCoordinates(x, y, w, h);

                    repaint();
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                        return;
                    }

                }
            }
        });
        thread.start();
    }
}


class PaintPanel extends JPanel
{
    private final Image image;
    private int imageX, imageY;
    private int imageW, imageH;

    PaintPanel()
    {
        image = new ImageIcon("Clipboard02.jpg").getImage();
        imageX = 0;
        imageY = 0;
        imageW = 0;
        imageH = 0;
    }

    void setImageCoordinates(int imageX, int imageY, int imageW, int imageH)
    {
        this.imageX = imageX;
        this.imageY = imageY;
        this.imageW = imageW;
        this.imageH = imageH;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        float scalingX = (float) imageW / image.getWidth(null);
        float scalingY = (float) imageH / image.getHeight(null);
        g.scale(scalingX, scalingY);

        int ix = (int)(imageX / scalingX);
        int iy = (int)(imageY / scalingY);
        g.drawImage(image, ix, iy, null);
    }
}