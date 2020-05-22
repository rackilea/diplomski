import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameSizeAfterDrag extends JFrame {

    //direction holds the position of drag
    private int w = 0, h = 0, direction, startX = 0, startY = 0;

    public JFrameSizeAfterDrag() {
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            //so we can see if from where the user clikced is he increasing or decraesing size
            @Override
            public void mousePressed(MouseEvent me) {
                super.mouseClicked(me);
                startX = me.getX();
                startY = me.getY();
                System.out.println("Clicked: " + startX + "," + startY);
            }

            //when the mouse is relaeased set size
            @Override
            public void mouseReleased(MouseEvent me) {
                super.mouseReleased(me);
                System.out.println("Mouse released");
                if (direction == 1 || direction == 2 || direction == 5 || direction == 6) {
                    setSize(w, h);
                } else {//this should move x and y by as much as the mouse moved then use setBounds(x,y,w,h);
                    setBounds(getX() - (startX - me.getX()), getY() - (startY - me.getY()), w, h);
                }
                validate();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            private boolean canResize;

            //while dragging check direction of drag
            @Override
            public void mouseDragged(MouseEvent me) {
                super.mouseDragged(me);
                System.out.println("Dragging:" + me.getX() + "," + me.getY());
                if (canResize && direction == 1) {//frame height  change
                    if (startY > me.getY()) {//decrease in height
                        h -= 4;
                    } else {//increase in height
                        h += 4;
                    }
                } else if (canResize && direction == 2) {//frame width  change
                    if (startX > me.getX()) {//decrease in width
                        w -= 4;
                    } else {//increase in width
                        w += 4;
                    }
                } else if (canResize && direction == 3) {//frame height  change
                    if (startX > me.getX()) {//decrease in width
                        w += 4;
                    } else {//increase in width
                        w -= 4;
                    }
                } else if (canResize && direction == 4) {//frame width  change
                    if (startY > me.getY()) {//decrease in height
                        h += 4;
                    } else {//increase in height
                        h -= 4;
                    }
                } else if (canResize && direction == 5) {//frame width and height  change bottom right
                    if (startY > me.getY() && startX > me.getX()) {//increase in height and width
                        h -= 4;
                        w -= 4;
                    } else {//decrease in height and with
                        h += 4;
                        w += 4;
                    }
                } /* Windows dont usually support reszing from top but if you want :) uncomment code in mouseMoved(..) also
                 else if (canResize && direction == 6) {//frame width and height  change top left
                 if (startY > me.getY() && startX > me.getX()) {//decrease in height and with
                 h += 4;
                 w += 4;
                 } else {//increase in height and width
                 h -= 4;
                 w -= 4;
                 }
                 } else if (canResize && direction == 8) {//frame width and height  change top right
                 if (startY > me.getY() && startX > me.getX()) {//increase in height and width
                 h -= 4;
                 w -= 4;
                 } else {//decrease in height and with
                 h += 4;
                 w += 4;
                 }
                 }
                 */ else if (canResize && direction == 7) {//frame width and height  change bottom left
                    if (startY > me.getY() && startX > me.getX()) {//increase in height and width
                        h -= 4;
                        w -= 4;
                    } else {//decrease in height and with
                        h += 4;
                        w += 4;
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                super.mouseMoved(me);
                if (me.getY() >= getHeight() - 10 && me.getX() >= getWidth() - 10) {//close to bottom and right side of frame show south east cursor and allow height witdh simaltneous increase/decrease
                    //System.out.println("resize allowed..");
                    canResize = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
                    direction = 5;
                } /*Windows dont usually support reszing from top but if you want :) uncomment code in mouseDragged(..) too
                 else if (me.getY() <= 28 && me.getX() <= 28) {//close to top side and left side of frame show north west cursor and only allow increase/decrease in width and height simultaneosly
                 //System.out.println("resize allowed..");
                 canResize = true;
                 setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                 direction = 6;
                 }  else if (me.getY() <= 28 && me.getX() >= getWidth() - 10) {//close to top and right side of frame show north east cursor and only allow increase/decrease in width and height simultaneosly
                 //System.out.println("resize allowed..");
                 canResize = true;
                 setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                 direction = 8;
                 } 
                 */ else if (me.getY() >= getHeight() - 10 && me.getX() <= 10) {//close to bottom side and left side of frame show north west cursor and only allow increase/decrease in width and height simultaneosly
                    //System.out.println("resize allowed..");
                    canResize = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
                    direction = 7;
                } else if (me.getY() >= getHeight() - 10) {//close to bottom of frame show south resize cursor and only allow increase height
                    //System.out.println("resize allowed");
                    canResize = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
                    direction = 1;
                } else if (me.getX() >= getWidth() - 10) {//close to right side of frame show east cursor and only allow increase width
                    //System.out.println("resize allowed");
                    canResize = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
                    direction = 2;
                } else if (me.getX() <= 10) {//close to left side of frame show east cursor and only allow increase width
                    //System.out.println("resize allowed");
                    canResize = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                    direction = 3;
                } else if (me.getY() <= 28) {//close to top side of frame show east cursor and only allow increase height
                    // System.out.println("resize allowed..");
                    canResize = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                    direction = 4;
                } else {
                    canResize = false;
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    // System.out.println("resize not allowed");
                }
            }
        });

        //just so GUI is visible and not small
        add(new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        });

        pack();
        setVisible(true);
    }

    @Override
    public void setVisible(boolean bln) {
        super.setVisible(bln);
        w = getWidth();
        h = getHeight();
    }

    public static void main(String[] args) {

        /**
         * Create GUI and components on Event-Dispatch-Thread
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameSizeAfterDrag();
            }
        });
    }
}