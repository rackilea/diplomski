package delete;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class AwtFrame extends Frame {
    AwtCanvas c;
    Panel p1;
    Label la_ax2, la_bx, la_c;
    TextField tf_Ax2, tf_bx, tf_c;

    public AwtFrame() {
        super("paint example.");
        this.setSize(800, 800);

        initComp();
        addComp();

        // TODO: write a graph drawing method
        c.repaint(); // paints a line of your graph

        this.setVisible(true);
    }

    public void initComp() {
        p1 = new Panel();
        la_ax2 = new Label("x^2 ");
        la_bx = new Label("+ x ");
        la_c = new Label("+ c ");

        tf_Ax2 = new TextField(0);
        tf_bx = new TextField(0);
        tf_c = new TextField(0);
        c = new AwtCanvas();
    }

    public void addComp() {
        this.setLayout(new BorderLayout());
        p1.setLayout(new FlowLayout());

        this.add(p1, BorderLayout.NORTH);
        this.add(c, BorderLayout.CENTER);

        p1.add(tf_Ax2);
        p1.add(la_ax2);
        p1.add(tf_bx);
        p1.add(la_bx);
        p1.add(tf_c);
        p1.add(la_c);
    }

    public static void main(String[] args) {
        new AwtFrame();
    }
}



package delete;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.LinkedList;

public class AwtCanvas extends Canvas {
//  LinkedList<ToImplement> coords = new LinkedList<ToImplement>();


    // TODO: implement plotter
    public void paint(Graphics g) {
        g.drawLine(40, 40, 100, 100);
        g.drawLine(54, 22, 300, 200);
    }

}