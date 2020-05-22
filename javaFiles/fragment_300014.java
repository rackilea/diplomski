import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Main extends JPanel {
    public static void main(String args[]) throws Exception {
        JFrame f = new JFrame("Shapes");
        f.setSize(600, 600);
        f.setLocation(300, 300);
        f.setResizable(true);
        JPanel p = new JPanel() {
            int x2 = 250;
            int y2 = 175;

            //for line
            int x1 = 315;
            int y1 = 115;
            int ex2 = 315;
            int ey2 = 115;


            //Middle Positive Sign
            private Shape lineMp = null;
            private Shape lineMn = null;

            //Border Positive Sign
            private Shape lineBp = null;
            private Shape lineBn = null;

            //Line
            private Shape line = null;
            {
                //Middle positive
                lineMn = new Line2D.Double(235,175,265,175);
                lineMp = new Line2D.Double(250,160,250,190);

                //Border sign
                lineBn = new Line2D.Double(300,115,330,115);
                lineBp = new Line2D.Double(315,115,315,130);

                //Line
                line = new Line2D.Double(x1,y1,x2,y2);


                MouseAdapter mouseAdapter = new MouseAdapter() {
                    private Point prevPoint;
                    @Override
                    public void mousePressed(MouseEvent e) {
                        prevPoint = e.getPoint();
                        System.out.println("Prev Point=" + prevPoint.toString());
                        repaint();
                    }
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        int dx = 0;
                        int dy = 0;
                        dx = (int) (prevPoint.x - e.getPoint().getX());
                        dy = (int) (prevPoint.y - e.getPoint().getY());

                        //Middle Positive sign
                        Line2D shapeMn = (Line2D) lineMn;
                        Line2D shapeMp = (Line2D) lineMp;

                        //Border sign
                        Line2D shapeBn = (Line2D) lineBn;
                        Line2D shapeBp = (Line2D) lineBp;

                        //Line
                        Line2D shapeline = (Line2D) line;

                        //Middle Positive sign
                        int nx1 = (int) (shapeMn.getX1() - dx);
                        int ny1 = (int) (shapeMn.getY1() - dy);

                        int nx2 = (int) (shapeMn.getX2() - dx);
                        int ny2 = (int) (shapeMn.getY2() - dy);

                        int px1 = (int) (shapeMp.getX1() - dx);
                        int py1 = (int) (shapeMp.getY1() - dy);

                        int px2 = (int) (shapeMp.getX2() - dx);
                        int py2 = (int) (shapeMp.getY2() - dy);

                        //Border sign
                        int Bnx1 = (int) (shapeBn.getX1() - dx);
                        int Bny1 = (int) (shapeBn.getY1() - dy);

                        int Bnx2 = (int) (shapeBn.getX2() - dx);
                        int Bny2 = (int) (shapeBn.getY2() - dy);

                        int Bpx1 = (int) (shapeBp.getX1() - dx);
                        int Bpy1 = (int) (shapeBp.getY1() - dy);

                        int Bpx2 = (int) (shapeBp.getX2() - dx);
                        int Bpy2 = (int) (shapeBp.getY2() - dy);

                        //Line
                        int x2 = (int) (shapeline.getX2() - dx);
                        int y2 = (int) (shapeline.getY2() - dy);

                        int ex1 = (int) (shapeline.getX1() - dx);
                        int ey1 = (int) (shapeline.getY1() - dy);

                        Point startPointMn = new Point(nx1, ny1);
                        Point endPointMn = new Point(nx2, ny2);
                        Point startPointMp = new Point(px1, py1);
                        Point endPointMp = new Point(px2, py2);

                        Point startPointBn = new Point(Bnx1, Bny1);
                        Point endPointBn = new Point(Bnx2, Bny2);
                        Point startPointBp = new Point(Bpx1, Bpy1);
                        Point endPointBp = new Point(Bpx2, Bpy2);

                        Point startPoint = new Point((int)shapeline.getX1(), (int)shapeline.getY1());
                        Point endPoint = new Point(x2, y2);

                        Point estartPoint = new Point(ex1, ey1);
                        Point eendPoint = new Point((int)shapeline.getX2(), (int)shapeline.getY2());

                        GeneralPath Mp = new GeneralPath();
                        Mp.append(lineMn, false);
                        Mp.append(lineMp, false);

                        if (Mp.getBounds().contains(prevPoint)) {
                            shapeline.setLine(startPoint,endPoint);
                            shapeMn.setLine(startPointMn, endPointMn);
                            shapeMp.setLine(startPointMp, endPointMp);
                            prevPoint = e.getPoint();
                            repaint();
                            return;
                        }

                        GeneralPath Bp = new GeneralPath();
                        Bp.append(lineBn, false);
                        Bp.append(lineBp, false);

                        if (Bp.getBounds().contains(prevPoint)) {
                            shapeline.setLine(estartPoint, eendPoint);
                            shapeBn.setLine(startPointBn, endPointBn);
                            shapeBp.setLine(startPointBp, endPointBp);
                            prevPoint = e.getPoint();
                            repaint();
                            return;
                        }

                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        repaint();
                    }
                };
                addMouseListener(mouseAdapter);
                addMouseMotionListener(mouseAdapter);
            }

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(Color.BLUE);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                if (lineMn != null){
                    g2d.draw(line);
                    g2d.draw(lineBn);
                    g2d.draw(lineBp);
                    g2d.draw(lineMn);
                    g2d.draw(lineMp);
                    }
            }};
        f.add(p);
        p.setLayout(null);
        f.setVisible(true);

    }
}