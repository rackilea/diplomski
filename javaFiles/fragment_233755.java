import java.awt.*;
import javax.swing.JApplet;

public class BarChart extends JApplet
{
    private final  int n=5;
    private String work[];
    private int value[];

    @Override
    public void init()
    {

        work = new String[n];
        value = new int[n];

        work[0] ="name";
        work[1] = "college";
        work[2] = "grade";
        work[3] = "nature";
        work[4] = "extra";

        value[0] = 20;
        value[1] = 10;
        value[2] = 4;
        value[3] = 15;
        value[4] = 5;

    }

    @Override
    public void paint(Graphics g)
    {
        Font font = new Font("Arial",Font.BOLD,15);
        g.setFont(font);
        for(int i  = 0; i < n; i ++)
        {
            g.setColor(Color.BLUE);
            g.drawString(work[i], 20, i * 50 + 30);
            g.setColor(Color.RED);
            g.fillRect(70, i * 50 + 10, value[i], 40);
            g.drawString(String.valueOf(value[i]) + "%", 180, i * 50 + 35);
        }


    }
}