import java.awt.Component;
import java.awt.FlowLayout;
import java.util.stream.Stream;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * <code>PopupSelection</code>.
 */
public class PopupSelection extends JFrame {
    private static final long serialVersionUID = 363879723515243543L;

    public PopupSelection() {
        super("something");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("right click me");

        JPopupMenu menu = new MyPopupMenu();
        menu.getSelectionModel().addChangeListener(System.out::println);

        JMenuItem menuItem1 = new JMenuItem("Item1");
        JMenuItem menuItem2 = new JMenuItem("Item2");
        JMenuItem menuItem3 = new JMenuItem("Item3");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        label.setComponentPopupMenu(menu);

        getContentPane().add(label);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PopupSelection().setVisible(true));
    }

    private static class MyPopupMenu extends JPopupMenu {

        private final ChangeListener listener = this::changed;

        @Override
        protected void addImpl(Component comp, Object constraints, int index) {
            super.addImpl(comp, constraints, index);
            if (comp instanceof AbstractButton) {
                ((AbstractButton) comp).getModel().addChangeListener(listener);
            }
        }

        @Override
        public void remove(int index) {
            Component comp = getComponent(index);
            if (comp instanceof AbstractButton) {
                ((AbstractButton) comp).getModel().removeChangeListener(listener);
            }
            super.remove(index);
        }

        private void changed(ChangeEvent e) {
            ButtonModel model = (ButtonModel) e.getSource();
            AbstractButton selected = Stream.of(getComponents()).filter(AbstractButton.class::isInstance)
                    .map(AbstractButton.class::cast)
                    .filter(b -> b.getModel().isArmed() && b.getModel() == model).findAny().orElse(null);
            setSelected(selected);
        }
    }
}