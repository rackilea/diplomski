import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class CardlayoutTest extends JFrame {

    private static final long serialVersionUID = 1L;
    public CardLayout card = new CardLayout();

    public CardlayoutTest() {
        JPanel pnlA = new JPanel(new BorderLayout());
        pnlA.add(new JButton("A"), BorderLayout.CENTER);
        JPanel pnlB = new JPanel(new BorderLayout());
        pnlB.add(new JButton("B"), BorderLayout.CENTER);
        JPanel pnlC = new JPanel(new BorderLayout());
        pnlC.add(new JButton("C"), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(card);
        add(pnlA, "A");
        add(pnlB, "B");
        add(pnlC, "C");

        pnlA.addAncestorListener(new EventHandler());
        pnlB.addAncestorListener(new EventHandler());
        pnlC.addAncestorListener(new EventHandler());

        pnlA.addHierarchyListener(new EventHandler());
        pnlB.addHierarchyListener(new EventHandler());
        pnlB.addHierarchyListener(new EventHandler());

        pnlA.addComponentListener(new EventHandler());
        pnlB.addComponentListener(new EventHandler());
        pnlB.addComponentListener(new EventHandler());
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

        public void componentHidden(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Hidden");
        }

        public void componentMoved(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Moved");
        }

        public void componentResized(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Resized ");
        }

        public void componentShown(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Shown");
        }
    }

    public static void main(String[] args) {
        CardlayoutTest t = new CardlayoutTest();
        t.setSize(500, 500);
        System.out.println("CardlayoutTest.main()------------------------ FIRST");
        t.card.show(t.getContentPane(), "A");
        t.setVisible(true);
        System.out.print("\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("CardlayoutTest.main()------------------------ SECOND");
        t.card.show(t.getContentPane(), "B");
        System.out.print("\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("CardlayoutTest.main()------------------------ THIRD");
        t.card.show(t.getContentPane(), "C");
        System.out.print("\n");
    }
}