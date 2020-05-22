import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import sun.awt.SunToolkit;

public class TestMenu {

    /**
     * Without a delay, SunToolkit may encounter a problem in SunToolkit (at
     * least in JDK 6, where the drop down size problem is not present).
     * 
     * Note: SunToolkit also has some mechanism to delay, but I forgot how it
     * worked.
     * 
     * <pre>
     * Exception in thread "main" sun.awt.SunToolkit$InfiniteLoop
     *         at sun.awt.SunToolkit.realSync(Unknown Source)
     *         at TestMenu.syncAndDelay(TestMenu.java:172)
     *         at TestMenu.click(TestMenu.java:88)
     *         at TestMenu.moveAndClickCenter(TestMenu.java:150)
     *         at TestMenu.main(TestMenu.java:45)
     * </pre>
     * 
     * As a bonus, the delay makes the scenario better visible for the human
     * eye.
     */
    private static int delay = 500;
    private static JMenu[] menus = new JMenu[5];
    private static Dimension[] parentSizes;
    private static Robot robot;
    private static SunToolkit toolkit;

    public static void main(String[] args) throws Exception {
        robot = new Robot();
        toolkit = (SunToolkit) Toolkit.getDefaultToolkit();
        parentSizes = new Dimension[menus.length];
        createGUI(); // Open the first menu. Then get the drop down size of all menu's
        moveAndClickCenter(menus[0]);
        for (int index = 0; index < menus.length; index++) {
            parentSizes[index] = getDropDownSize(index);
        }// Click the last item on the last menu.        
        Component item = menus[menus.length - 1].getMenuComponent(menus[menus.length - 1].getMenuComponentCount() - 1);
        moveAndClickCenter(item);
        // Open the last drop down again. Then get the drop down sizes once more. If size not equal to previous size, then it's a bug.
        boolean bug = false;
        moveAndClickCenter(menus[menus.length - 1]);
        for (int index = menus.length - 1; index >= 0; index--) {
            Dimension currentSize = getDropDownSize(index);
            System.out.print("old: " + parentSizes[index] + ", new: " + currentSize);
            if (!parentSizes[index].equals(currentSize)) {
                bug = true;
                System.out.println(" ERROR");
            } else {
                System.out.println();
            }
        }
        if (bug) {
            throw new RuntimeException("JMenu drop down size is changed for no reason.");
        }

    }

    private static Dimension getDropDownSize(int index) throws Exception {
        moveToCenter(menus[index]);
        return menus[index].getMenuComponent(0).getParent().getSize();
    }

    private static void click() throws Exception {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        syncAndDelay();
    }

    private static void createGUI() throws Exception {

        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();// The L&F defines the drop down policy.
                for (final UIManager.LookAndFeelInfo info : infos) {
                    if (info.getName().toLowerCase().indexOf("metal") >= 0) {
                        if (!UIManager.getLookAndFeel().getName().equals(info.getName())) {
                            try {
                                UIManager.setLookAndFeel(info.getClassName());
                                System.out.println("Attempt to set look and feel to " + info.getName());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Metal look and feel is the default");
                        }
                        break;
                    }
                }
                System.out.println("Testing with " + UIManager.getLookAndFeel().getName());  // Setup the GUI.
                JFrame frame = new JFrame("A frame");
                frame.setJMenuBar(new JMenuBar());
                for (int menuIndex = 0; menuIndex < menus.length; menuIndex++) {
                    menus[menuIndex] = new JMenu("Menu " + menuIndex);
                    frame.getJMenuBar().add(menus[menuIndex]);
                    for (int itemIndex = 0; itemIndex <= menus.length - menuIndex; itemIndex++) {
                        // It seems that the problem only occurs if the drop down is displayed outside the frame at the right
                        // (not sure though). A rather long item name.
                        JMenuItem item = new JMenuItem("Menu " + menuIndex + " item " + itemIndex);
                        menus[menuIndex].add(item);
                    }
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        syncAndDelay();
    }

    private static void moveAndClickCenter(Component c) throws Exception {
        moveToCenter(c);
        click();
    }

    private static void moveToCenter(final Component c) throws Exception {
        final Point cp = new Point();
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                Point p = new Point(c.getWidth() / 2, c.getHeight() / 2);
                SwingUtilities.convertPointToScreen(p, c);
                cp.setLocation(p);
            }
        });
        robot.mouseMove(cp.x, cp.y);
        syncAndDelay();
    }

    private static void syncAndDelay() throws Exception {
        if (delay > 0) {
            Thread.sleep(delay);
        }
        toolkit.realSync();
    }

    private TestMenu() {
    }
}