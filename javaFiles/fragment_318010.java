import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelsWithSharedList extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 250;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public PanelsWithSharedList() {
        for (int i = 0; i < 10; i++) {
            listModel.addElement("List element " + (i + 1));
        }

        setLayout(new BorderLayout());
        add(tabbedPane);
        tabbedPane.add("Panel 1", new ListShowingPanel1(listModel));
        tabbedPane.add("Panel 2", new ListShowingPanel2(listModel));
        tabbedPane.add("Panel 3", new ListShowingPanel3(listModel));
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }

    private static void createAndShowGui() {
        PanelsWithSharedList mainPanel = new PanelsWithSharedList();

        JFrame frame = new JFrame("Panels With Shared List");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
abstract class AbstractListShowingPanel extends JPanel {
    private JList<String> list;

    public AbstractListShowingPanel(DefaultListModel<String> listModel) {
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public JList<String> getList() {
        return list;
    }

    public DefaultListModel<String> getModel() {
        return (DefaultListModel<String>) list.getModel();
    }
}

@SuppressWarnings("serial")
class ListShowingPanel1 extends AbstractListShowingPanel {
    private JTextField textField = new JTextField(10);

    public ListShowingPanel1(DefaultListModel<String> listModel) {
        super(listModel);
        add(new JScrollPane(getList()));
        add(new JLabel("Text to add:"));

        Action action = new AddTextAction();
        textField.setAction(action);
        add(textField);
        add(new JButton(action));

    }

    private class AddTextAction extends AbstractAction {
        public AddTextAction() {
            super("Add Text");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getModel().addElement(textField.getText());
            textField.selectAll();
        }
    }

}

@SuppressWarnings("serial")
class ListShowingPanel2 extends AbstractListShowingPanel {
    public ListShowingPanel2(DefaultListModel<String> listModel) {
        super(listModel);
        add(new JScrollPane(getList()));
        add(new JButton(new DeleteItemAction()));
    }

    private class DeleteItemAction extends AbstractAction {
        public DeleteItemAction() {
            super("Delete Selected Item");
            putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        }

        public void actionPerformed(ActionEvent e) {
            JList<String> list = getList();
            String selection = list.getSelectedValue();
            if (selection != null) {
                getModel().removeElement(selection);
            }
        }
    }
}

@SuppressWarnings("serial")
class ListShowingPanel3 extends AbstractListShowingPanel {
    public ListShowingPanel3(DefaultListModel<String> listModel) {
        super(listModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(getList()));
    }
}