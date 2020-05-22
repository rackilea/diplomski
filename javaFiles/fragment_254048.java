import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Graph extends JApplet{

    public void init(){

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Container conn = getContentPane();
                conn.setLayout(new BorderLayout());

                Panel p = new Panel();//graph
                conn.add(p,BorderLayout.CENTER);

                Box box1 = new Box(BoxLayout.Y_AXIS);
                PanelB a = new PanelB(box1);//vertical
                conn.add(a,BorderLayout.LINE_START);

                Box box2 = new Box(BoxLayout.X_AXIS);
                PanelC b = new PanelC(box2);//horizontal
                conn.add(b,BorderLayout.PAGE_END);
            }
        });
    }
}

class Panel extends JPanel {

    public Panel(){
        this.setBackground(Color.yellow);
    }

    @Override
    public Dimension getPreferredSize()
    {   
        return (new Dimension(460,560));
    }

    public void paintComponent(Graphics p) {

        super.paintComponent(p);

        Graphics2D graph = (Graphics2D)p;

        Dimension appletSize = this.getSize();
        int appletHeight = (int)(appletSize.height);
        int appletWidth = appletSize.width;

        this.setBackground(Color.yellow);//set background color.

        int x,y,y1,x1,a,b,p1x,p1y,p2x,p2y;

        //line co-ordinates
        //the numbers represent the number of boxes on the graph
        int xstart = 7;
        int ystart = 1;

        int xfinish = 3;
        int yfinish = 9;

        //other variables
        int i = 0;
        int i2 = 0;
        int m = 0;
        int n = 0;
        int m2 = 0;
        int n2 = 0;
        int f2 = 0;
        int g2 = 1;

        //ranges
        int f = 5;
        int g = -5;

        //change -ve num to +ve
        int g3 = Math.abs(g);

        int a1 = g3 + f;
        int b1 = a1;

        y1 = (appletHeight);
        x1 = (appletWidth);
        y = (appletHeight / 2);
        x = (appletWidth / 2);
        a = (appletWidth / a1);
        b = (appletHeight / b1);

        int d = (appletWidth / a1);
        int e = (appletHeight / b1);

        /**
         to determine the
         ammount of pixles there
         is in each box of the
         graph, both y-axis and 
         x-axis
         */
        int xbox = x1 / 10;
        int ybox = y1 / 10;

        //line variables
        //the xstart, ystart, etc represent the number of boxes

        //top point of the line on the graph
        p1x = xbox * xstart;//start x
        p1y = ybox * ystart;//start y

        //lowwer point of the line on the graph
        p2x = xbox * xfinish;//finish x
        p2y = ybox * yfinish;//finish y

        //draw y-axis numbers 
        //(+ve)
        while(f != 0){
            String s = String.valueOf(f);
            p.drawString(s,(x + 5),m + 13);
            m = m + b;
            f = f - 1;
        }
        //(-ve)
        m2 = y;
        while(f2 != g-1){
            String u = String.valueOf(f2);
            p.drawString(u,(x + 5),m2 - 3);
            m2 = m2 + b;
            f2 = f2 - 1;
        }
        //draw x-axis numbers.
        //(-ve)
        while(g != 0){
            String t = String.valueOf(g);
            p.drawString(t,n,y - 5);
            n = n + a;
            g = g + 1;
        }
        //(+ve)
        n2 = x + a;
        while(g2 != g3+1){
            String vw = String.valueOf(g2);
            p.drawString(vw,n2 -10,y - 5);
            n2 = n2 + a;
            g2 = g2 + 1;
        }

        BasicStroke aLine2 = new BasicStroke(1.0F,
           BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        graph.setStroke(aLine2);

        //notch on numbers and grid lines
        //left to right, top to bottom notches
        int v2 = -5;
        int v5 = 0;
        while(i <= a1-1){
            p.setColor(Color.lightGray);//lightgray line
            p.drawLine(a,0,a,y1);//vertical lightgray
            p.drawLine(0,b,x1,b);//horizontal lightgray
            a = a + d;
            b = b + e;
            i = i + 1;
        }
        //notches
        while(i2 <= a1){
            p.setColor(Color.blue);//notch color
            p.drawString("x",v2+2,y+3);//xaxis
            p.drawString("x",x-4,v5+4);//yaxis
            v5 = v5 + e;
            v2 = v2 + d;
            i2 = i2 + 1;
        }

        //draws the border of the graph
        p.setColor(Color.black);
        Rectangle2D.Float rect = new Rectangle2D.Float(0,0,x1,y1);
        BasicStroke aLine = new BasicStroke(2.5F, 
               BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        graph.setStroke(aLine);
        graph.draw(rect);

        //draw cross
        BasicStroke aLine3 = new BasicStroke(2.5F,
                     BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        graph.setStroke(aLine3);
        p.drawLine(x,0,x,y1); //vertical line
        p.drawLine(0,y,x1,y); //horizontal line

        //display the value of graph width and graph height
        String aw = String.valueOf(x1);
        p.drawString("Graph Width = ", 50,90);
        p.drawString(aw,150,90);
        p.drawString("Graph Height = ", 50,110);
        String ah = String.valueOf(y1);
        p.drawString(ah,156,110);

        //draw line on graph

        BasicStroke aLine4 = new BasicStroke(1.5F,
                         BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        graph.setStroke(aLine4);
        p.setColor(Color.red);

        if(p1x <= x1 && p2x <= x1 && p1y <= y1 && p2y <= y1){
            p.drawLine(p1x,p1y,p2x,p2y);
            Color c = new Color(0,0,0);
            p.setColor(c);
            p.drawString("X", p1x-4,p1y+4);
            p.drawString("X", p2x-4,p2y+4);
        }
        else{
            p.setColor(Color.black);
            p.drawRect(48,34,223,35);
            p.setColor(Color.white);
            p.fillRect(49,35,222,34);
            p.setColor(Color.red);
            p.drawString("Wrong co-ordinates!!!", 50,50);
            p.drawString("Values exceede applet dimensions.", 50,65);
        }
    }
}

class PanelB extends JPanel{

    public PanelB (Box a) {

        a = Box.createVerticalBox();
        a.add(new JLabel("Please enter the values below:"));
        a.add(new JLabel("a"));
        JTextField g1 = new JTextField("0.0");
        g1.setMaximumSize(new Dimension(100,30));
        a.add(g1);
        a.add(new JLabel("b"));
        JTextField g2 = new JTextField("0.0");
        g2.setMaximumSize(new Dimension(100,30));
        a.add(g2);
        a.add(new JLabel("c"));
        JTextField g3 = new JTextField("0.0");
        g3.setMaximumSize(new Dimension(100,30));
        a.add(g3);
        a.add(new JLabel("d"));
        JTextField g4 = new JTextField("0.0");
        g4.setMaximumSize(new Dimension(100,30));
        a.add(g4);
        a.add(new JButton("Plot"));
        a.add(new JButton("Refine"));
        add(a);
    }

    @Override
    public Dimension getPreferredSize()
    {   
        return (new Dimension(200,100));
    }
}

class PanelC extends JPanel{

    public PanelC (Box b) {

        b = Box.createHorizontalBox();
        b.add(new JLabel("a"));
        JTextField f1 = new JTextField("0.0");
        f1.setMaximumSize(new Dimension(100,30));
        b.add(f1);
        b.add(new JLabel("b"));
        JTextField f2 = new JTextField("0.0");
        f2.setMaximumSize(new Dimension(100,30));
        b.add(f2);
        b.add(new JLabel("c"));
        JTextField f3 = new JTextField("0.0");
        f3.setMaximumSize(new Dimension(100,30));
        b.add(f3);
        b.add(new JLabel("d"));
        JTextField f4 = new JTextField("0.0");
        f4.setMaximumSize(new Dimension(100,30));
        b.add(f4);
        b.add(new JButton("Plot"));
        b.add(new JButton("Refine"));
        add(b);
    }

    @Override
    public Dimension getPreferredSize()
    {   
        return (new Dimension(201,50));
    }
}