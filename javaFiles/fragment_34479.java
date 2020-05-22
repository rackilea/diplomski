import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MyTabbedPane {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JFrame f = new JFrame();
    private JLabel label1 = new JLabel("Tab1");
    private JLabel label2 = new JLabel("Tab2");
    private JLabel label3 = new JLabel("Tab3");
    private JLabel label4 = new JLabel("Tab4");

    public MyTabbedPane() {
        tabbedPane.addTab("Tab1", label1);
        tabbedPane.addTab("Tab2", label2);
        tabbedPane.addTab("Tab3", label3);
        tabbedPane.addTab("Tab4", label4);
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        label1.addAncestorListener(new EventHandler());
        label2.addAncestorListener(new EventHandler());
        label3.addAncestorListener(new EventHandler());
        label4.addAncestorListener(new EventHandler());

        label1.addHierarchyListener(new EventHandler());
        label2.addHierarchyListener(new EventHandler());
        label3.addHierarchyListener(new EventHandler());
        label4.addAncestorListener(new EventHandler());

        label1.addComponentListener(new EventHandler());
        label2.addComponentListener(new EventHandler());
        label3.addComponentListener(new EventHandler());
        label4.addComponentListener(new EventHandler());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(tabbedPane, BorderLayout.CENTER);
        f.setPreferredSize(new Dimension(600, 400));
        f.pack();
        f.setVisible(true);
    }

    class EventHandler implements AncestorListener, ComponentListener, HierarchyListener {

        @Override
        public void ancestorAdded(AncestorEvent event) {
            System.out.println("CardlayoutTest.EventHandler.ancestorAdded()");
        }

        @Override
        public void ancestorMoved(AncestorEvent event) {
            System.out.println("CardlayoutTest.EventHandler.ancestorMoved()");
        }

        @Override
        public void ancestorRemoved(AncestorEvent event) {
            System.out.println("CardlayoutTest.EventHandler.ancestorRemoved()");
        }

        @Override
        public void hierarchyChanged(HierarchyEvent e) {
            System.out.println("Components Change: " + e.getChanged());
            if ((e.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0) {
                if (e.getComponent().isDisplayable()) {
                    System.out.println("Components DISPLAYABILITY_CHANGED : " + e.getChanged());
                } else {
                    System.out.println("Components DISPLAYABILITY_CHANGED : " + e.getChanged());
                }
            }
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0) {
                if (e.getComponent().isDisplayable()) {
                    System.out.println("Components SHOWING_CHANGED : " + e.getChanged());
                } else {
                    System.out.println("Components SHOWING_CHANGED : " + e.getChanged());
                }
            }
        }

        @Override
        public void componentHidden(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Hidden");
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Moved");
        }

        @Override
        public void componentResized(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Resized ");
        }

        @Override
        public void componentShown(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Shown");
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyTabbedPane frame = new MyTabbedPane();

            }
        });
    }
}