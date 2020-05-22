import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @see http://stackoverflow.com/a/12389479/909085
 */
public class ComponentLinkerTest extends JComponent {

    private List<Map.Entry<Component, Component>> linked;
    private static ComponentLinkerTest linker;
    private static JRadioButton last = null;

    public static void main(String[] args) {
            setupLookAndFeel();
            JFrame frame = new JFrame();
            JPanel general = new javax.swing.JPanel();
            JPanel botones = new javax.swing.JPanel();
            general.setLayout(new javax.swing.BoxLayout(general, javax.swing.BoxLayout.LINE_AXIS));
            linker = new ComponentLinkerTest();
            frame.setGlassPane(linker);
            linker.setVisible(true);

            JPanel content = new JPanel();
            content.setLayout(new GridLayout(10, 10, 5, 5));
            content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            general.add(content);
            JButton aceptar = new JButton("Generar ruta");
            aceptar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                       System.out.println(linker.toString());
                                    }
            });
            botones.add(aceptar);
            general.add(botones);
            frame.add(general);
            int a=0;
            int b= 0;
            //frame.add ( content );
            for (int i = 0; i < 100; i++) {
                if(b==10){
                    a++;
                    b=0;
                }
                String pos = "";
                pos=a+","+b;
                final JRadioButton button = new JRadioButton();
                button.setName(pos);
                //final JButton button = new JButton ();
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setSelected(true);
                        link(button);
                    }
                });
                content.add(button);
                b++;
            }

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    public ComponentLinkerTest() {
        super();
        linked = new ArrayList<Map.Entry<Component,Component>>();
    }

    public void link(JComponent c1, JComponent c2) {
        Map.Entry entry = new AbstractMap.SimpleEntry<>(c1, c2);
        linked.add(entry);
        repaint();
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.BLACK);
        for (Map.Entry entry : linked) {
            Point p1 = getRectCenter(getBoundsInWindow((Component)entry.getKey()));
            Point p2 = getRectCenter(getBoundsInWindow((Component)entry.getValue()));
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private Point getRectCenter(Rectangle rect) {
        return new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
    }

    private Rectangle getBoundsInWindow(Component component) {
        return getRelativeBounds(component, getRootPaneAncestor(component));
    }

    private Rectangle getRelativeBounds(Component component,
            Component relativeTo) {
        return new Rectangle(getRelativeLocation(component, relativeTo),
                component.getSize());
    }

    private Point getRelativeLocation(Component component, Component relativeTo) {
        Point los = component.getLocationOnScreen();
        Point rt = relativeTo.getLocationOnScreen();
        return new Point(los.x - rt.x, los.y - rt.y);
    }

    private JRootPane getRootPaneAncestor(Component c) {
        for (Container p = c.getParent(); p != null; p = p.getParent()) {
            if (p instanceof JRootPane) {
                return (JRootPane) p;
            }
        }
        return null;
    }

    public boolean contains(int x, int y) {
        return false;
    }

    private static void link(JRadioButton button) {
        System.out.println("" + button.getName());
        if (last == null) {
            last = button;
        } else {
            linker.link(last, button);
            last = null;
        }
    }

    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}